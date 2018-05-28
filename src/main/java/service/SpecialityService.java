package service;

import dao.DaoDepartment;
import dao.DaoSpeciality;
import factory.DaoFactory;
import model.Department;
import model.Speciality;

public class SpecialityService implements IService {
    DaoDepartment daoDepartment = DaoFactory.getInstance().getDaoDepartment();
    DaoSpeciality daoSpeciality = DaoFactory.getInstance().getDaoSpeciality();

    public Speciality get(int id) {
        return daoSpeciality.get(id);
    }

    public Speciality getSpecialityByDepartment(Department department) {
        return daoSpeciality.get(department.getSpecialityId());
    }

    public Speciality getSpecialityByDepartmentId(int departmentId) {
        return getSpecialityByDepartment(daoDepartment.get(departmentId));
    }
}
