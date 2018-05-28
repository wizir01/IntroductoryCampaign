package commands;

import factory.ServiceFactory;
import model.University;
import service.IUniversityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowUniversitiesCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUniversityService universityService = ServiceFactory.getInstance().getUniversityService();
        List<University> universities = universityService.getAll();
        request.setAttribute("universities", universities);
        return "/view/universities.jsp";
    }
}
