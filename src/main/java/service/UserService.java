package service;

import dao.DaoUser;
import factory.DaoFactory;
import model.User;

import java.util.List;

public class UserService implements IUserService {
    DaoUser daoUser = DaoFactory.getInstance().getDaoUser();

    public List<User> getAll() {
        return daoUser.getAll();
    }

    public boolean create(User user) {
        return daoUser.create(user);
    }

    public User get(int id) {
        return daoUser.get(id);
    }

    public User getByEmail(String email) {
        return daoUser.getByEmail(email);
    }
}
