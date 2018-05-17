package dao;

import factory.PropertyHandlerFactory;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoUser implements IDao<User> {
    private static final Logger LOGGER = LogManager.getLogger(DaoUser.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();

    @Override
    public boolean create(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("user_create"))) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setBoolean(4, user.isAdmin());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("user_update"))) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setBoolean(4, user.isAdmin());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public User get(int id) {
        User user = null;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("user_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            user = DBParser.createUser(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return user;
    }

//    public User getByName(String name) {
//        User user = null;
//
//        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
//            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("user_getByName"))) {
//
//            preparedStatement.setString(1, name);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            user = DBParser.createUser(resultSet).get(0);
////            List<User> users = DBParser.createUser(resultSet);
////            if (!users.isEmpty()) {
////                user = users.get(0);
////            }
//        } catch (SQLException e) {
//            LOGGER.error("Some problem was ocured while working with database \n" + e);
//            return null;
//        }
//        return user;
//    }

    public User getByEmail(String email) {
        User user = null;
        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("user_getByEmail"))) {

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = DBParser.createUser(resultSet);
            if (!users.isEmpty()) {
                user = users.get(0);
            }

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return user;
    }


        @Override
    public List<User> getAll() {
        List<User> users;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("user_getAll"));
            users = DBParser.createUser(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return users;
    }

    @Override
    public boolean delete(int id) {

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("user_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }


}
