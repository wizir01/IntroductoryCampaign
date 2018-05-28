package commands;

import factory.ServiceFactory;
import model.ExamsExtra;
import model.User;
import service.IExamsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowExamsCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IExamsService examsService = ServiceFactory.getInstance().getExamsService();
        User user = (User)request.getSession().getAttribute("user");

        if (user.isAdmin()) {
            List<ExamsExtra> exams = examsService.getAllExtra();
            request.setAttribute("exams", exams);
            request.setAttribute("admin", true);
        }else {
            List<ExamsExtra> exams = examsService.getByUserExtra(user.getId());
            request.setAttribute("exams", exams);
            request.setAttribute("admin", false);

        }

        return "/view/exams.jsp";
    }
}
