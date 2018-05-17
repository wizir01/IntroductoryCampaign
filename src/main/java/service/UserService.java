package service;

import dao.DaoUser;
import factory.DaoFactory;
import model.User;

import java.util.List;

public class UserService implements IService {
    DaoUser daoUser = DaoFactory.getInstance().getDaoUser();

    public List<User> getAll() {
        return daoUser.getAll();
    }

    public void create(User user) {
        daoUser.create(user);
    }

    public User get(int id) {
        return daoUser.get(id);
    }

    public User getByEmail(String email) {
        return daoUser.getByEmail(email);
    }
}
