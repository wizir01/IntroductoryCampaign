package service;

import model.Department;
import model.DepartmentExtra;
import model.Speciality;

import java.util.List;

public interface IDepartmentService extends IService {

    List<DepartmentExtra> createExtra(List<Department> departments);

    Department get(int id);

    List<Department> getByUniversity(int id);

    List<Speciality> getSpecialitiesByUniversity(int id);

    List<DepartmentExtra> getExtraByUniversity(int id);
}
