package properties;

import java.util.Properties;

abstract class PropertyHandler {
    final Properties properties;

    PropertyHandler(Properties properties) {
        this.properties = properties;
    }

    public abstract String get(String key);

    public Properties get() {
        return properties;
    }
}
