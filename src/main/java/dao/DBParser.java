package dao;

import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBParser {
    private static final Logger LOGGER = LogManager.getLogger(DBParser.class);

    static public List<User> createUser(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("User_id");
                String name = resultSet.getString("Name");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("Password");
                boolean Is_Admin = resultSet.getBoolean("Is_Admin");
                User user = new User(id, name, Email, Password, Is_Admin);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing User + \n" + e);
        }
        return users;
    }

    static public List<University> createUniversity(ResultSet resultSet) throws SQLException {
        List<University> universities = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("University_id");
                String name = resultSet.getString("UniversityName");
                University university = new University(id, name);
                universities.add(university);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing University + \n" + e);
        }
        return universities;
    }

    static public List<Subject> createSubject(ResultSet resultSet) throws SQLException {
        List<Subject> subjects = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("Subjects_id");
                String name = resultSet.getString("SubjectName");
                Subject subject = new Subject(id, name);
                subjects.add(subject);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing Subject + \n" + e);
        }
        return subjects;
    }

    static public List<Speciality> createSpeciality(ResultSet resultSet) throws SQLException {
        List<Speciality> specialities = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("Speciality_id");
                String name = resultSet.getString("SpecialityName");
                Speciality speciality = new Speciality(id, name);
                specialities.add(speciality);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing Speciality + \n" + e);
        }
        return specialities;
    }

    static public List<Exams> createExams(ResultSet resultSet) throws SQLException {
        List<Exams> exams = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("Exams_id");
                int Subjects_id = resultSet.getInt("Subjects_id");
                int User_id = resultSet.getInt("User_id");
                int Mark = resultSet.getInt("Mark");
                Exams exam = new Exams(id, Subjects_id, User_id, Mark);
                exams.add(exam);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing Speciality + \n" + e);
        }
        return exams;
    }

    static public List<Department> createDepartment(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("Department_id");
                int Speciality_id = resultSet.getInt("Speciality_id");
                int University_id = resultSet.getInt("University_id");
                int StudyPlacesNumber = resultSet.getInt("StudyPlacesNumber");
                Department department = new Department(id, Speciality_id, University_id, StudyPlacesNumber);
                departments.add(department);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing Speciality + \n" + e);
        }
        return departments;
    }

    static public List<DepartmentRequirement> createDepartmentRequirement(ResultSet resultSet) throws SQLException {
        List<DepartmentRequirement> departmentRequirements = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("DepReq_id");
                int Department_id = resultSet.getInt("Department_id");
                int Subject_id = resultSet.getInt("Subject_id");
                DepartmentRequirement departmentRequirement = new DepartmentRequirement(id, Department_id, Subject_id);
                departmentRequirements.add(departmentRequirement);
            }
        }catch (SQLException e) {
            throw new SQLException("Some problem was occurred while parsing Speciality + \n" + e);
        }
        return departmentRequirements;
    }

    static public List<Rating> createRating(ResultSet resultSet) throws SQLException {
        List<Rating> ratings = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("Rating_id");
                int User_id = resultSet.getInt("User_id");
                int Department_id = resultSet.getInt("Department_id");
                int Rating = resultSet.getInt("Rating");
                Rating rating = new Rating(id, User_id, Department_id, Rating);
                ratings.add(rating);
            }

        }catch (SQLException e) {
            throw  new SQLException("Some problem was occurred while parsing Speciality + \n" + e);
        }
        return ratings;
    }
}
