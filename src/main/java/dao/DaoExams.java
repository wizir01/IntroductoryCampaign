package dao;

import factory.PropertyHandlerFactory;
import model.Exams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DaoExams implements IDao<Exams> {
    private static final Logger LOGGER = LogManager.getLogger(DaoExams.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();
    
    @Override
    public boolean create(Exams exams) {
        if (exams == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_create"))) {

            preparedStatement.setInt(1, exams.getSubjectId());
            preparedStatement.setInt(2, exams.getUserId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }


    public boolean create(int Subjects_id, int User_id) {

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_create"))) {

            preparedStatement.setInt(1, Subjects_id);
            preparedStatement.setInt(2, User_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    public boolean setMark(int Exams_id, int Mark) {
        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_setMark"))) {

            preparedStatement.setInt(1, Mark);
            preparedStatement.setInt(2, Exams_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Exams exams) {
        if (exams == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_update"))) {

            preparedStatement.setInt(1, exams.getSubjectId());
            preparedStatement.setInt(2, exams.getUserId());
            preparedStatement.setInt(3, exams.getMark());
            preparedStatement.setInt(4, exams.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public Exams get(int id) {
        Exams exams = null;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            exams = DBParser.createExams(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return exams;
    }

    public List<Exams> getByUserId(int User_id) {
        List<Exams> exams;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_getByUserId"))) {

            preparedStatement.setInt(1, User_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            exams = DBParser.createExams(resultSet);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return exams;
    }

    @Override
    public List<Exams> getAll() {
        List<Exams> exams;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("exams_getAll"));
            exams = DBParser.createExams(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return exams;
    }

    @Override
    public boolean delete(int id) {
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("exams_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }
}