package factory;

import service.*;

public class ServiceFactory {
    private static final ServiceFactory ourInstance = new ServiceFactory();
    private final UserService userService = new UserService();
    private final UniversityService universityService = new UniversityService();
    private final SubjectService subjectService = new SubjectService();
    private final SpecialityService specialityService = new SpecialityService();
    private final RatingService ratingService = new RatingService();
    private final ExamsService examsService = new ExamsService();
    private final DepartmentService departmentService = new DepartmentService();
    private final DepartmentRequirementService departmentRequirementService = new DepartmentRequirementService();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public UniversityService getUniversityService() {
        return universityService;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public SpecialityService getSpecialityService() {
        return specialityService;
    }

    public RatingService getRatingService() {
        return ratingService;
    }

    public ExamsService getExamsService() {
        return examsService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public DepartmentRequirementService getDepartmentRequirementService() {
        return departmentRequirementService;
    }
}
