package factory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.MailPropertyHandler;
import properties.QueryPropertyHandler;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;


public class PropertyHandlerFactory {
    private static final PropertyHandlerFactory ourInstance = new PropertyHandlerFactory();
    private QueryPropertyHandler queryPropertyHandler;
    private MailPropertyHandler mailPropertyHandler;

    private static final Logger LOGGER = LogManager.getLogger(PropertyHandlerFactory.class);

    private PropertyHandlerFactory() {
        init();
    }

    public static PropertyHandlerFactory getInstance() {
        return ourInstance;
    }

    private void init() {
        Properties queryProperties = new Properties();
        Properties mailProperties = new Properties();

        try (InputStream queryStream = getClass().getResourceAsStream("/query.properties");
        InputStream mailStream = getClass().getResourceAsStream("/mail.properties")) {

            queryProperties.load(queryStream);
            mailProperties.load(mailStream);

        } catch (FileNotFoundException e) {
            LOGGER.error("Some problem was ocured while open property file \n" + e);
        } catch (IOException e) {
            LOGGER.error("Some problem was ocured while working with property file \n" + e);
        }
        queryPropertyHandler = new QueryPropertyHandler(queryProperties);
        mailPropertyHandler = new MailPropertyHandler(mailProperties);
    }

    public QueryPropertyHandler getQueryPropertyHandler() {
        return queryPropertyHandler;
    }

    public MailPropertyHandler getMailPropertyHandler() {return mailPropertyHandler;}

}
