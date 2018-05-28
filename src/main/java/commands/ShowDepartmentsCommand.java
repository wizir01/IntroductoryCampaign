package commands;

import factory.ServiceFactory;
import model.Department;
import model.DepartmentExtra;
import model.User;
import service.IDepartmentService;
import service.IRatingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ShowDepartmentsCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDepartmentService departmentService = ServiceFactory.getInstance().getDepartmentService();
        IRatingService ratingService = ServiceFactory.getInstance().getRatingService();
        User user = (User) request.getSession().getAttribute("user");
        int UniversityId = Integer.parseInt(request.getParameter("UniversityId"));
        List<DepartmentExtra> departments = departmentService.getExtraByUniversity(UniversityId);

        if (user.isAdmin()) {
            request.setAttribute("isAdmin", true);
        }else {
            List<Integer> selected = ratingService.getDepartmentsIdsByUser(user.getId());
            Iterator<DepartmentExtra> iter = departments.iterator();
            while (iter.hasNext()) {
                if (selected.contains(iter.next().getId())) {
                    iter.remove();
                }
            }
        }
        request.setAttribute("departments", departments);
        return "/?command=ShowUniversitiesCommand";
    }
}
