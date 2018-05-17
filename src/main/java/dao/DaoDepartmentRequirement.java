package dao;

import factory.PropertyHandlerFactory;
import model.DepartmentRequirement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DaoDepartmentRequirement implements IDao<DepartmentRequirement> {
    private static final Logger LOGGER = LogManager.getLogger(DaoDepartmentRequirement.class);
    private final QueryPropertyHandler property = PropertyHandlerFactory.getInstance().getQueryPropertyHandler();

    @Override
    public boolean create(DepartmentRequirement departmentRequirement) {
        if (departmentRequirement == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmentrequirement_create"))) {

            preparedStatement.setInt(1, departmentRequirement.getDepartmentId());
            preparedStatement.setInt(2, departmentRequirement.getSubjectId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(DepartmentRequirement departmentRequirement) {
        if (departmentRequirement == null) {
            throw new IllegalArgumentException();
        }

        try (ConnectionProxy connection = TransactionManager.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmentrequirement_update"))) {

            preparedStatement.setInt(1, departmentRequirement.getDepartmentId());
            preparedStatement.setInt(2, departmentRequirement.getSubjectId());
            preparedStatement.setInt(3, departmentRequirement.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }

    @Override
    public DepartmentRequirement get(int id) {
        DepartmentRequirement departmentRequirement = null;
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmentrequirement_get"))) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            departmentRequirement = DBParser.createDepartmentRequirement(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }

        return departmentRequirement;
    }

    @Override
    public List<DepartmentRequirement> getAll() {
        List<DepartmentRequirement> departmentRequirements;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(property.get("departmentrequirement_getAll"));
            departmentRequirements = DBParser.createDepartmentRequirement(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return departmentRequirements;
    }

    public List<DepartmentRequirement> getByDepartmentId(int Department_id) {
        List<DepartmentRequirement> departmentRequirements;

        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmentrequirement_getByDepartmentId"))) {

            preparedStatement.setInt(1, Department_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            departmentRequirements = DBParser.createDepartmentRequirement(resultSet);

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return null;
        }
        return departmentRequirements;
    }

    @Override
    public boolean delete(int id) {
        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.createPreparedStatement(property.get("departmentrequirement_delete"))) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            LOGGER.error("Some problem was ocured while working with database \n" + e);
            return false;
        }
        return true;
    }
}
