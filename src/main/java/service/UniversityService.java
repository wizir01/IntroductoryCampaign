package service;

import dao.DaoUniversity;
import factory.DaoFactory;
import model.University;

import java.util.List;

public class UniversityService implements IService {
    private final DaoUniversity daoUniversity = DaoFactory.getInstance().getDaoUniversity();

    public List<University> getAll() {
        return daoUniversity.getAll();
    }
}
