package commands;

import factory.ServiceFactory;
import model.User;
import service.IExamsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectSubjectsCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IExamsService examsService = ServiceFactory.getInstance().getExamsService();
        User user = (User) request.getSession().getAttribute("user");
        String [] subjectsId = request.getParameterValues("subjectId");

        if (subjectsId == null) {
            request.setAttribute("emptyCheckbox", "none selected");
            return "/?command=ShowSubjectCommand";
        }

        for (String subjectId : subjectsId) {
            if(examsService.create(Integer.parseInt(subjectId), user.getId())) {
                continue;
            }else {
                return "/view/error.jsp";
            }
        }
        return "/?command=ShowSubjectCommand";
    }
}
