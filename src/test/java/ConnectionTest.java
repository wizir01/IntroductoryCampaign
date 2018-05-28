import dao.*;
import datasourse.DataSource;
import factory.DaoFactory;
import factory.ServiceFactory;
import model.*;
import notification.MessageSender;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import service.*;

import java.sql.*;
import java.util.*;

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
//        IDepartmentRequirementService departmentRequirementService = ServiceFactory.getInstance().getDepartmentRequirementService();
        IExamsService examsService = ServiceFactory.getInstance().getExamsService();
//        IRatingService ratingService= ServiceFactory.getInstance().getRatingService();
//        ISubjectService subjectService = ServiceFactory.getInstance().getSubjectService();
        DaoExams daoExams = DaoFactory.getInstance().getDaoExams();

//        System.out.println(examsService.create( 1, 12));


    }

}
