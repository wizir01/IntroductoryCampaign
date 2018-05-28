package commands;

import factory.ServiceFactory;
import model.MessageInfo;
import notification.MessageSender;
import service.IRatingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SendNotificationsCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageSender messageSender = MessageSender.getInstance();
        IRatingService ratingService = ServiceFactory.getInstance().getRatingService();
        List<List<MessageInfo>> messageInfo = ratingService.getReadyInfos();
        try {
            for (List<MessageInfo> mesInf : messageInfo) {
                for (MessageInfo mi : mesInf) {
                    messageSender.sendMessage(mi);
                }
            }
        }catch (Exception e) {
            request.setAttribute("Send", "Problem with sending notifications");
            return "/?command=RatingCommand";
        }
        request.setAttribute("Send", "Notifications have been sent");
        return "/?command=RatingCommand";
    }
}
