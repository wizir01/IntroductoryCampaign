package properties;

import java.util.Properties;

public class QueryPropertyHandler extends PropertyHandler {
    public QueryPropertyHandler(Properties properties) {
        super(properties);
    }

    @Override
    public String get(String key) {
        return properties.getProperty(key);
    }
}
