package service;

import model.University;

import java.util.List;

public interface IUniversityService extends IService {

    List<University> getAll();

    University get(int universityId);
}
