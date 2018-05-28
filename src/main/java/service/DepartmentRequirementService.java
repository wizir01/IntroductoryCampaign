package service;

import dao.DaoDepartmentRequirement;
import dao.DaoSubject;
import factory.DaoFactory;
import model.DepartmentRequirement;
import model.Exams;
import model.Subject;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRequirementService implements IDepartmentRequirementService {
    private final DaoDepartmentRequirement daoDepartmentRequirement = DaoFactory.getInstance().getDaoDepartmentRequirement();
    private final DaoSubject daoSubject = DaoFactory.getInstance().getDaoSubject();

    public List<DepartmentRequirement> getByDepartment(int id) {
        return daoDepartmentRequirement.getByDepartmentId(id);
    }

    public List<Subject> getSubjectsByDepartment(int id) {
        List<Subject> subjects = new ArrayList<>();
        List<DepartmentRequirement> departmentRequirements = getByDepartment(id);

        for (DepartmentRequirement departmentRequirement : departmentRequirements) {
            Subject subject = daoSubject.get(departmentRequirement.getSubjectId());
            subjects.add(subject);
        }
        return subjects;
    }

    public List<Integer> getSubjectsIdByDepartment(int id) {
        List<Integer> result = new ArrayList<>();
        List<Subject> subjects = getSubjectsByDepartment(id);
        for (Subject subject : subjects) {
            result.add(subject.getId());
        }
        return result;
    }

    public int check(List<Exams> exams, int DepartmentId) {
        int counter = 0;
        int rating = 0;
        List<Integer> requirements = getSubjectsIdByDepartment(DepartmentId);
        for (Exams exam : exams) {
            if (exam.getMark() > 0 && requirements.contains(exam.getSubjectId())) {
                counter++;
                rating += exam.getMark();
            }
        }
        if (counter == 3) {
            return rating;
        }else {
            return 0;
        }


    }

}
