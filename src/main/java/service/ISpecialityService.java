package service;

import model.Department;
import model.Speciality;

public interface ISpecialityService extends IService {

    Speciality get(int id);

    Speciality getSpecialityByDepartment(Department department);

    Speciality getSpecialityByDepartmentId(int departmentId);
}
