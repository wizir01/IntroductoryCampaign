package controller;

import commands.RegistrationCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    ControllerHelper controllerHelper = ControllerHelper.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean logginStatus = session.getAttribute("user") != null;
        if ("RegistrationCommand".equals(req.getParameter("command")) && !logginStatus) {
            req.getRequestDispatcher("/view/registration.jsp").forward(req, resp);
        }
        if (!logginStatus) {
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }else {
            executeCommand(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executeCommand(req, resp);
    }

    private void executeCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String index = controllerHelper.getCommand(req).execute(req, resp);
        req.getRequestDispatcher(index).forward(req, resp);
    }


}
