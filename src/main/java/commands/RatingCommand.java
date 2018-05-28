package commands;

import factory.ServiceFactory;
import model.DepartmentExtra;
import model.User;
import service.IDepartmentService;
import service.IRatingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatingCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IRatingService ratingService = ServiceFactory.getInstance().getRatingService();
        IDepartmentService departmentService = ServiceFactory.getInstance().getDepartmentService();
        User user = (User) request.getSession().getAttribute("user");
        List<DepartmentExtra> departments = new ArrayList<>();

        if (user.isAdmin()) {
            departments = departmentService.createExtra(ratingService.getAllDepartments());
            request.setAttribute("isAdmin", true);
        }else {
            int userId = user.getId();
            departments = departmentService.createExtra(ratingService.getDepartmentsByUser(userId));
        }
        request.setAttribute("departments", departments);
        return "/view/rating.jsp";
    }
}
