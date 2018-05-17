package commands;

import factory.ServiceFactory;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements ICommand {
//    final String index = "/WEB-INF/view/registration.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserService userService = ServiceFactory.getInstance().getUserService();
        User EmailCheck = userService.getByEmail(email);

        if ("".equals(name) || "".equals(email) || "".equals(password)) {
            request.setAttribute("error", "Some field is empty");
            return "/view/registration.jsp";
        }

        if (EmailCheck != null) {
            request.setAttribute("error", "Email is already registered");
            return "/view/registration.jsp";
        }

        User user = new User(name, email, password, false);
        ServiceFactory.getInstance().getUserService().create(user);
        request.getSession().setAttribute("user", user);
        return "/view/main.jsp";

    }
}
