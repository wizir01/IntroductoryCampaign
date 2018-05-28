package controller;

import commands.*;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerHelper {

    private static Map<String, ICommand> commandMap = new HashMap<>();

    private static ControllerHelper ourInstance = new ControllerHelper();

    public static ControllerHelper getInstance() {
        return ourInstance;
    }

    private ControllerHelper() {
        commandMap.put("LoginCommand", new LoginCommand());
        commandMap.put("LogoutCommand", new LogoutCommand());
        commandMap.put("RegistrationCommand", new RegistrationCommand());
        commandMap.put("ShowSubjectCommand", new ShowSubjectsCommand());
        commandMap.put("SelectSubjectsCommand", new SelectSubjectsCommand());
        commandMap.put("MainCommand", new MainCommand());
        commandMap.put("ShowExamsCommand", new ShowExamsCommand());
        commandMap.put("SetMarkCommand", new SetMarkCommand());
        commandMap.put("ShowUniversitiesCommand", new ShowUniversitiesCommand());
        commandMap.put("ShowDepartmentsCommand", new ShowDepartmentsCommand());
        commandMap.put("SelectDepartmentCommand", new SelectDepartmentCommand());
        commandMap.put("RatingCommand", new RatingCommand());
        commandMap.put("ShowRatingCommand", new ShowRatingCommand());
        commandMap.put("SendNotificationsCommand", new SendNotificationsCommand());
        commandMap.put("LocalizationCommand", new LocalizationCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String key = request.getParameter("command");
        return commandMap.get(key);
    }
}
