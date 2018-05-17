package commands;

import factory.ServiceFactory;
import model.Subject;
import model.User;
import service.ExamsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectSubjectsCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamsService examsService = ServiceFactory.getInstance().getExamsService();
        User user = (User) request.getSession().getAttribute("user");
        List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
        examsService.create(user, subjects);
        return "/view/subjects.jsp";
    }
}
