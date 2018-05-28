package commands;

import factory.ServiceFactory;
import model.Exams;
import model.Subject;
import model.User;
import service.IDepartmentRequirementService;
import service.IExamsService;
import service.IRatingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectDepartmentCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDepartmentRequirementService departmentRequirementService = ServiceFactory.getInstance().getDepartmentRequirementService();
        IExamsService examsService = ServiceFactory.getInstance().getExamsService();
        IRatingService ratingService = ServiceFactory.getInstance().getRatingService();
        User user = (User) request.getSession().getAttribute("user");
        int departmentId = Integer.parseInt(request.getParameter("DepartmentId"));
        int userId = user.getId();
        List<Exams> exams = examsService.getByUser(userId);
        int rating = departmentRequirementService.check(exams, departmentId);

        if (rating > 0) {
            ratingService.create(userId, departmentId, rating);
            return "/?command=RatingCommand";
        }else {
            List<Subject> reqSubjects = departmentRequirementService.getSubjectsByDepartment(departmentId);
            request.setAttribute("reqSubjects", reqSubjects);
            request.setAttribute("failure", "failure, required exams:");
            return "/?command=ShowUniversitiesCommand";
        }
    }
}