package factory;

import dao.*;

public class DaoFactory {
    private static final DaoFactory ourInstance = new DaoFactory();
    private static final DaoUser daoUser = new DaoUser();
    private static final DaoUniversity daoUniversity = new DaoUniversity();
    private static final DaoSubject daoSubject = new DaoSubject();
    private static final DaoSpeciality daoSpeciality = new DaoSpeciality();
    private static final DaoRating daoRating = new DaoRating();
    private static final DaoExams daoExams = new DaoExams();
    private static final DaoDepartmentRequirement daoDepartmentRequirement = new DaoDepartmentRequirement();
    private static final DaoDepartment daoDepartment = new DaoDepartment();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
    }

    public DaoUser getDaoUser() {
        return daoUser;
    }

    public DaoUniversity getDaoUniversity() {
        return daoUniversity;
    }

    public DaoSubject getDaoSubject() {
        return daoSubject;
    }

    public DaoSpeciality getDaoSpeciality() {
        return daoSpeciality;
    }

    public DaoRating getDaoRating() {
        return daoRating;
    }

    public DaoExams getDaoExams() {
        return daoExams;
    }

    public DaoDepartmentRequirement getDaoDepartmentRequirement() {
        return daoDepartmentRequirement;
    }

    public DaoDepartment getDaoDepartment() {
        return daoDepartment;
    }
}
