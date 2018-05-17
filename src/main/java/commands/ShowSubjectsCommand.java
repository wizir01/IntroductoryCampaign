package commands;

import factory.ServiceFactory;
import model.Subject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowSubjectsCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = ServiceFactory.getInstance().getSubjectService().getAll();
        request.setAttribute("subjects", subjects);
        return "/view/subjects.jsp";
    }
}