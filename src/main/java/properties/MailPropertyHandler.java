package properties;

import java.util.Properties;

public class MailPropertyHandler extends PropertyHandler {
    public MailPropertyHandler(Properties properties) {
        super(properties);
    }

    @Override
    public String get(String key) {
        return properties.getProperty(key);
    }
}
