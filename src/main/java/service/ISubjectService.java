package service;

import model.Subject;

import java.util.List;

public interface ISubjectService extends IService {

    Subject get(int id);

    List<Subject> getAll();
}
