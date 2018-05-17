package dao;

import factory.PropertyHandlerFactory;
import model.Subject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoSubject implements IDao<Subject> {
    private static final Logger LOGGER = LogManager.getLogger(DaoSubject.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();

    @Override
    public boolean create(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("subject_create"))) {

            preparedStatement.setString(1, subject.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("subject_update"))) {

            preparedStatement.setString(1, subject.getName());
            preparedStatement.setInt(2, subject.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public Subject get(int id) {
        Subject subject = null;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("subject_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            subject = DBParser.createSubject(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return subject;
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjects;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("subject_getAll"));
            subjects = DBParser.createSubject(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return subjects;
    }

    @Override
    public boolean delete(int id) {
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("subject_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }
}
