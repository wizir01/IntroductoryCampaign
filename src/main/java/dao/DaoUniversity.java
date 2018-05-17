package dao;

import factory.PropertyHandlerFactory;
import model.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoUniversity implements IDao<University> {
    private static final Logger LOGGER = LogManager.getLogger(DaoUniversity.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();

    @Override
    public boolean create(University university) {
        if (university == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("university_create"))) {

            preparedStatement.setString(1, university.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(University university) {
        if (university == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("university_update"))) {

            preparedStatement.setString(1, university.getName());
            preparedStatement.setInt(2, university.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public University get(int id) {
        University university = null;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("university_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            university = DBParser.createUniversity(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return university;
    }

    @Override
    public List<University> getAll() {
        List<University> universities;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("university_getAll"));
            universities = DBParser.createUniversity(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return universities;
    }

    @Override
    public boolean delete(int id) {

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("university_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }
}
