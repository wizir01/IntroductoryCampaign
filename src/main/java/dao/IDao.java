package dao;

import java.util.List;

public interface IDao<T> {

    boolean create(T t);

    boolean update(T t);

    T get(int id);

    List<T> getAll();

    boolean delete(int id);
}
