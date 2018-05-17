package dao;

import factory.PropertyHandlerFactory;
import model.Exams;
import model.Rating;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoRating implements IDao<Rating>{
    private static final Logger LOGGER = LogManager.getLogger(DaoRating.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();

    @Override
    public boolean create(Rating rating) {
        if (rating == null) {
            throw new IllegalArgumentException();
        }

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("rating_create"))) {

            preparedStatement.setInt(1, rating.getUserId());
            preparedStatement.setInt(2, rating.getDepartmentId());
            preparedStatement.setInt(3, rating.getRating());
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Rating rating) {
        if (rating == null) {
            throw new IllegalArgumentException();
        }

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("rating_update"))) {

            preparedStatement.setInt(1, rating.getUserId());
            preparedStatement.setInt(2, rating.getDepartmentId());
            preparedStatement.setInt(3, rating.getRating());
            preparedStatement.setInt(4, rating.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }

        return true;
    }

    @Override
    public Rating get(int id) {
        Rating rating = null;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("rating_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            rating = DBParser.createRating(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return rating;
        }

        return rating;
    }

    public List<Rating> getByUserId(int User_id) {
        List<Rating> ratings;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("rating_getByUserId"))) {

            preparedStatement.setInt(1, User_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ratings = DBParser.createRating(resultSet);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return ratings;
    }

    public List<Rating> getByDepartment(int Department_id) {
        List<Rating> ratings;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("rating_getByDepartmentId"))) {

            preparedStatement.setInt(1, Department_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ratings = DBParser.createRating(resultSet);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return ratings;
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> ratings;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("rating_getAll"));
            ratings = DBParser.createRating(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return ratings;
    }

    @Override
    public boolean delete(int id) {
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("rating_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }
}
