package service;

import model.User;

import java.util.List;

public interface IUserService extends IService {

    List<User> getAll();

    boolean create(User user);

    User get(int id);

    User getByEmail(String email);
}
