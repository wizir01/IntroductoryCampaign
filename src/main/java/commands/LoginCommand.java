package commands;

import factory.ServiceFactory;
import model.User;
import service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        IUserService userService  = ServiceFactory.getInstance().getUserService();
        User user = userService.getByEmail(email);

        if (user == null || "".equals(email)) {
            request.setAttribute("notFound", "Invalid login or password!");
            return "/view/login.jsp";
        }
        if (user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            return "/view/main.jsp";
        }else {
            request.setAttribute("notFound", "Invalid login or password!");
            return "/view/login.jsp";
        }
    }
}
