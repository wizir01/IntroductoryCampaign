package notification;

import factory.PropertyHandlerFactory;
import model.MessageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.MailPropertyHandler;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MessageSender {
    private static MessageSender ourInstance = new MessageSender();
    private static final Logger LOGGER = LogManager.getLogger(MessageSender.class);
    private final MailPropertyHandler properties = PropertyHandlerFactory.getInstance().getMailPropertyHandler();


    public static MessageSender getInstance() {
        return ourInstance;
    }

    private MessageSender() {
    }

    public void sendMessage(MessageInfo messageInfo) {
        Properties property = properties.get();
        Session mailSession = Session.getDefaultInstance(property);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(property.getProperty("mail.smtps.user"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(messageInfo.getEmail()));
            message.setSubject("Congratulations you have passed !");
            message.setText("Dear, " + messageInfo.getName() + " ! You have successfully passed to the Faculty: " + messageInfo.getSpeciality() + " at the University: " + messageInfo.getUniversity());

            Transport tr = mailSession.getTransport();
            tr.connect("introductory.campaign@gmail.com", "123654ic");
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
        }catch (Exception e) {
            LOGGER.error("Some problem was ocured while sending mail \n" + e);
        }
    }
}
