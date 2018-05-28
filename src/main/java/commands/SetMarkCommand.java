package commands;

import factory.ServiceFactory;
import service.IExamsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetMarkCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IExamsService examsService = ServiceFactory.getInstance().getExamsService();
        String id = request.getParameter("id");
        String mark = request.getParameter("mark");

        if ("".equals(mark)) {
            request.setAttribute("emptyField", "field is empty");
            return "/?command=ShowExamsCommand";
        }

        if (examsService.setMark(Integer.parseInt(id), Integer.parseInt(mark))) {
            return "/?command=ShowExamsCommand";
        }else {
            return "/view/error.jsp";
        }
    }
}
