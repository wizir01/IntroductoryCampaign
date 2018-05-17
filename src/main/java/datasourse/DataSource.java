package datasourse;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static DataSource Instance = new DataSource();
    ComboPooledDataSource comboPooledDataSource;
private final Logger LOGGER = LogManager.getLogger(DataSource.class);

    public static DataSource getInstance() {
        return Instance;
    }

    private DataSource() {
        initDataSourse();
    }

    private void initDataSourse() {
        comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();

        try(InputStream stream = getClass().getResourceAsStream("/jdbc.properties")){
            properties.load(stream);
            comboPooledDataSource.setDriverClass(properties.getProperty("DRIVER"));
        }catch (FileNotFoundException e) {
            LOGGER.error("Some problem was ocured while open property file \n" + e);
        }catch (IOException e) {
            LOGGER.error("Some problem was ocured while close property file \n" + e);
        }catch (PropertyVetoException e) {
            LOGGER.error("Some problrem was occured while loading driver \n" + e);
        }

        comboPooledDataSource.setJdbcUrl(properties.getProperty("URL"));
        comboPooledDataSource.setUser(properties.getProperty("USERNAME"));
        comboPooledDataSource.setPassword(properties.getProperty("PASSWORD"));

    }

    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = comboPooledDataSource.getConnection();
        }catch (SQLException e) {
            LOGGER.error("Some problem was occurred while getting connection \n" + e);
        }
        return connection;
    }
}
