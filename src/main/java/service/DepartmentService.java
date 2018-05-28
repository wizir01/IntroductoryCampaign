package service;

import dao.DaoDepartment;
import dao.DaoSpeciality;
import factory.DaoFactory;
import model.Department;
import model.DepartmentExtra;
import model.Speciality;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements IDepartmentService {
    private final DaoDepartment daoDepartment = DaoFactory.getInstance().getDaoDepartment();
    private final DaoSpeciality daoSpeciality = DaoFactory.getInstance().getDaoSpeciality();

    public List<DepartmentExtra> createExtra(List<Department> departments) {
        List<DepartmentExtra> departmentExtras = new ArrayList<>();
        for (Department department : departments) {
            departmentExtras.add(new DepartmentExtra(department.getId(), daoSpeciality.get(department.getSpecialityId()).getName(), department.getStudyPlacesNumber()));
        }
        return departmentExtras;
    }

    public Department get(int id) {
        return daoDepartment.get(id);
    }

    public List<Department> getByUniversity(int id) {
        return daoDepartment.getByUniversityId(id);
    }

    public List<DepartmentExtra> getExtraByUniversity(int id) {
        return createExtra(getByUniversity(id));
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
