package service;

import dao.DaoUniversity;
import factory.DaoFactory;
import model.University;

import java.util.List;

public class UniversityService implements IUniversityService {
    private final DaoUniversity daoUniversity = DaoFactory.getInstance().getDaoUniversity();

    public List<University> getAll() {
        return daoUniversity.getAll();
    }

    public University get(int universityId) {
        return daoUniversity.get(universityId);
    }
}
