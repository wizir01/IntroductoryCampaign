import dao.ConnectionProxy;
import dao.DBParser;
import dao.TransactionManager;
import datasourse.DataSource;
import factory.DaoFactory;
import factory.ServiceFactory;
import model.Department;
import model.Subject;
import org.apache.logging.log4j.Logger;
import model.User;
import org.apache.logging.log4j.LogManager;
import service.DepartmentService;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionTest {

//    public static User getByName(String name) {
//        final Logger LOGGER = LogManager.getLogger(ConnectionTest.class);
//        User user = null;
//
//        try(ConnectionProxy connection = TransactionManager.getInstance().getConnection();
//            PreparedStatement preparedStatement = connection.createPreparedStatement("SELECT * FROM user WHERE Name = ?")) {
//
//            preparedStatement.setString(1, name);
//            ResultSet resultSet = preparedStatement.executeQuery();
////            System.out.println(resultSet.next());
////            user = DBParser.createUser(resultSet).get(0);
//            List<User> users = DBParser.createUser(resultSet);
//            System.out.println(users);
//            if (!users.isEmpty()) {
//                user = users.get(0);
//            }
//        } catch (SQLException e) {
//            LOGGER.error("Some problem was ocured while working with database \n" + e);
//            return null;
//        }
//        return user;
//    }

    public static void main(String[] args) {
        List<Subject> subjects = ServiceFactory.getInstance().getSubjectService().getAll();
        System.out.println(subjects);
    }

}
