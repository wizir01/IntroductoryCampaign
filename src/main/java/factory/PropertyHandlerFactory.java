package factory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.QueryPropertyHandler;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyHandlerFactory {
    private static final PropertyHandlerFactory ourInstance = new PropertyHandlerFactory();
    private QueryPropertyHandler queryPropertyHandler;

    private static final Logger LOGGER = LogManager.getLogger(PropertyHandlerFactory.class);

    private PropertyHandlerFactory() {
        init();
    }

    public static PropertyHandlerFactory getInstance() {
        return ourInstance;
    }

    private void init() {
        Properties properties = new Properties();

        try (InputStream stream = getClass().getResourceAsStream("/query.properties")) {
            properties.load(stream);
        } catch (FileNotFoundException e) {
            LOGGER.error("Some problem was ocured while open property file \n" + e);
        } catch (IOException e) {
            LOGGER.error("Some problem was ocured while close property file \n" + e);
        }
        queryPropertyHandler = new QueryPropertyHandler(properties);
    }

    public QueryPropertyHandler getQueryPropertyHandler() {
        return queryPropertyHandler;
    }

}
