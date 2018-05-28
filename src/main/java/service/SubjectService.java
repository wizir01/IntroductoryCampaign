package service;

import dao.DaoSubject;
import factory.DaoFactory;
import model.Subject;

import java.util.List;

public class SubjectService implements ISubjectService {
    private final DaoSubject daoSubject = DaoFactory.getInstance().getDaoSubject();

    public Subject get(int id) {
        return daoSubject.get(id);
    }

    public List<Subject> getAll() {
        return daoSubject.getAll();
    }
}
