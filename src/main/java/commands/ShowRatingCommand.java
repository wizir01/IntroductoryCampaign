package commands;

import factory.ServiceFactory;
import model.RatingExtra;
import service.IRatingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowRatingCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IRatingService ratingService = ServiceFactory.getInstance().getRatingService();
        int departmentId = Integer.parseInt(request.getParameter("DepartmentId"));
        List<RatingExtra> ratings = ratingService.getExtraByDepartment(departmentId);
        request.setAttribute("ratings", ratings);
        return "/?command=RatingCommand";
    }
}
