package service;

import dao.*;
import factory.DaoFactory;
import model.Department;
import model.MessageInfo;
import model.Rating;
import model.RatingExtra;

import java.util.*;

public class RatingService implements IRatingService {
    DaoRating daoRating = DaoFactory.getInstance().getDaoRating();
    DaoUser daoUser = DaoFactory.getInstance().getDaoUser();
    DaoSpeciality daoSpeciality = DaoFactory.getInstance().getDaoSpeciality();
    DaoDepartment daoDepartment = DaoFactory.getInstance().getDaoDepartment();
    DaoUniversity daoUniversity = DaoFactory.getInstance().getDaoUniversity();

    public boolean create(Rating rating) {
        return daoRating.create(rating);
    }

    public boolean create(int UserId, int DepartmentId, int Rating) {
        Rating rating = new Rating(UserId, DepartmentId, Rating);
        return create(rating);
    }

    public List<Rating> getAll() {
        return daoRating.getAll();
    }

    public List<Rating> getByUser(int UserId) {
        return daoRating.getByUserId(UserId);
    }

    public List<Department> getAllDepartments() {
        List<Rating> ratings = getAll();
        List<Department> departments = new ArrayList<>();
        for (Rating rating : ratings) {
            departments.add(daoDepartment.get(rating.getDepartmentId()));
        }
        Set<Department> set = new HashSet<>(departments);
        departments = new ArrayList<>(set);
        return departments;
    }

    public List<Department> getDepartmentsByUser(int UserId) {
        List<Department> departments = new ArrayList<>();
        List<Rating> userRatings = getByUser(UserId);
        for (Rating rating : userRatings) {
            departments.add(daoDepartment.get(rating.getDepartmentId()));
        }
        return departments;
    }

    public List<Integer> getDepartmentsIdsByUser(int UserId) {
        List<Integer> result = new ArrayList<>();
        List<Department> departments = getDepartmentsByUser(UserId);
        for (Department department : departments) {
            result.add(department.getId());
        }
        return result;
    }

    public List<Rating> getByDepartment(int DepartmentId) {
        return daoRating.getByDepartment(DepartmentId);
    }

    public List<RatingExtra> getExtraByDepartment(int DepartmentId) {
        return createExtra(getByDepartment(DepartmentId));
    }

    public List<List<RatingExtra>> getAllExtraByAllDepartments() {
        List<Department> departments = getAllDepartments();
        List<List<RatingExtra>> result = new ArrayList<>();
        for (Department department : departments) {
            result.add(getExtraByDepartment(department.getId()));
        }
        return result;
    }

    public List<List<MessageInfo>> getReadyInfos() {
        List<List<MessageInfo>> messageInfos = new ArrayList<>();
        List<List<RatingExtra>> ratingExtras = getAllExtraByAllDepartments();
        for (List<RatingExtra> re : ratingExtras) {
            Collections.sort(re);
            Collections.reverse(re);
            int places = daoDepartment.get(re.get(0).getDepartmentId()).getStudyPlacesNumber();
            Iterator<RatingExtra> iter = re.iterator();
            while (iter.hasNext()) {
                iter.next();
                if(places <= 0) {
                    iter.remove();
                }
                places--;
            }
            messageInfos.add(createMessageInfo(re));
        }
        return messageInfos;
    }



    public List<MessageInfo> createMessageInfo(List<RatingExtra> ratingExtras) {
        List<MessageInfo> result = new ArrayList<>();
        for (RatingExtra r : ratingExtras) {
            result.add(new MessageInfo(r.getUserName(), r.getUserEmail(), r.getSpecialityName(), r.getUniversityName()));
        }
        return result;
    }


    public List<RatingExtra> createExtra(List<Rating> ratings) {
        List<RatingExtra> ratingExtras = new ArrayList<>();
        for (Rating rating : ratings) {
            ratingExtras.add(new RatingExtra(rating.getId(), rating.getUserId(), rating.getDepartmentId(), rating.getRating(), daoUser.get(rating.getUserId()).getName(), daoUser.get(rating.getUserId()).getEmail(), daoSpeciality.get(daoDepartment.get(rating.getDepartmentId()).getSpecialityId()).getName(), daoUniversity.get(daoDepartment.get(rating.getDepartmentId()).getUniversityId()).getName()));
        }
        return ratingExtras;
    }

    public List<List<Rating>> getByUserDepartments(int UserId) {
        List<Rating> userRatings = getByUser(UserId);
        List<List<Rating>> ratingsByUserDepartments = new ArrayList<>();

        for (Rating rating : userRatings) {
            ratingsByUserDepartments.add(getByDepartment(rating.getDepartmentId()));
        }
        return ratingsByUserDepartments;
    }

    public List<List<RatingExtra>> getExtraByUserDepartments(int UserId) {
        List<List<Rating>> ratings = getByUserDepartments(UserId);
        List<List<RatingExtra>> result = new ArrayList<>();
        for (List<Rating> ratingList : ratings) {
            result.add(createExtra(ratingList));
        }
        return result;
    }

}