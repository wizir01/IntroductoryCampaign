package service;

import dao.DaoDepartment;
import dao.DaoSpeciality;
import factory.DaoFactory;
import model.Department;
import model.Speciality;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements IService {
    private final DaoDepartment daoDepartment = DaoFactory.getInstance().getDaoDepartment();
    private final DaoSpeciality daoSpeciality = DaoFactory.getInstance().getDaoSpeciality();

    public List<Department> getByUniversity(int id) {
        return daoDepartment.getByUniversityId(id);
    }


    public List<Speciality> getSpecialitiesByUniversity(int id) {
        List<Speciality> specialities = new ArrayList<>();
        List<Department> departments = getByUniversity(id);

        for (Department department : departments) {
            Speciality speciality = daoSpeciality.get(department.getSpecialityId());
            specialities.add(speciality);
        }
        return specialities;
    }


}
