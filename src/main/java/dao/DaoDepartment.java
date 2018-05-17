package dao;

import factory.PropertyHandlerFactory;
import model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoDepartment implements IDao<Department> {
    private static final Logger LOGGER = LogManager.getLogger(DaoDepartment.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();

    @Override
    public boolean create(Department department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("department_create"))) {

            preparedStatement.setInt(1, department.getSpecialityId());
            preparedStatement.setInt(2, department.getUniversityId());
            preparedStatement.setInt(3, department.getStudyPlacesNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Department department) {
        if (department == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("department_update"))) {

            preparedStatement.setInt(1, department.getSpecialityId());
            preparedStatement.setInt(2, department.getUniversityId());
            preparedStatement.setInt(3, department.getStudyPlacesNumber());
            preparedStatement.setInt(4, department.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public Department get(int id) {
        Department department = null;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("department_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            department = DBParser.createDepartment(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("department_getAll"));
            departments = DBParser.createDepartment(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return departments;
    }

    public List<Department> getByUniversityId(int University_id) {
        List<Department> departments;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmnet_getByUniversityId"))) {

            preparedStatement.setInt(1, University_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            departments = DBParser.createDepartment(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return departments;
    }

    public List<Department> getBySpecialityId(int Speciality_id) {
        List<Department> departments;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmnet_getBySpecialityId"))) {

            preparedStatement.setInt(1, Speciality_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            departments = DBParser.createDepartment(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return departments;
    }

    @Override
    public boolean delete(int id) {
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("department_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }
}
