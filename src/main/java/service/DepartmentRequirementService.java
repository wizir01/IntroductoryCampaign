package service;

import dao.DaoDepartmentRequirement;
import dao.DaoSubject;
import factory.DaoFactory;
import model.DepartmentRequirement;
import model.Subject;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRequirementService implements IService {
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

}
