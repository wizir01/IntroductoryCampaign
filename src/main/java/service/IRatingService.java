package service;

import model.Department;
import model.MessageInfo;
import model.Rating;
import model.RatingExtra;

import java.util.List;

public interface IRatingService extends IService {

    boolean create(Rating rating);

    boolean create(int UserId, int DepartmentId, int Rating);

    List<Rating> getAll();

    List<Rating> getByUser(int UserId);

    List<Department> getAllDepartments();

    List<Department> getDepartmentsByUser(int UserId);

    List<Integer> getDepartmentsIdsByUser(int UserId);

    List<Rating> getByDepartment(int DepartmentId);

    List<RatingExtra> getExtraByDepartment(int DepartmentId);

    List<List<RatingExtra>> getAllExtraByAllDepartments();

    List<List<MessageInfo>> getReadyInfos();

    List<MessageInfo> createMessageInfo(List<RatingExtra> ratingExtras);

    List<List<Rating>> getByUserDepartments(int UserId);

    List<RatingExtra> createExtra(List<Rating> ratings);
}
