package service;

import model.DepartmentRequirement;
import model.Exams;
import model.Subject;

import java.util.List;

public interface IDepartmentRequirementService extends IService {

    List<DepartmentRequirement> getByDepartment(int id);

    List<Subject> getSubjectsByDepartment(int id);

    List<Integer> getSubjectsIdByDepartment(int id);

    int check(List<Exams> exams, int DepartmentId);
}
