package commands;

import factory.ServiceFactory;
import model.Subject;
import model.User;
import service.IExamsService;
import service.ISubjectService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class ShowSubjectsCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISubjectService subjectService = ServiceFactory.getInstance().getSubjectService();
        IExamsService examsService = ServiceFactory.getInstance().getExamsService();
        User user = (User) request.getSession().getAttribute("user");
        List<Subject> subjects = subjectService.getAll();
        List<Integer> examsId = examsService.getSubjectIdByUser(user.getId());
        ListIterator<Subject> iterator = subjects.listIterator();

        while (iterator.hasNext()) {
            if (examsId.contains(iterator.next().getId())) {
                iterator.remove();
            }
        }
        if (user.isAdmin() || subjects.isEmpty()) {
            request.setAttribute("noAvailable", "No available subjects");
            return "/view/subjects.jsp";
        }
        request.setAttribute("subjects", subjects);
        return "/view/subjects.jsp";
    }
}