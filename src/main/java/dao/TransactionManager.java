package dao;

import datasourse.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;


public class TransactionManager {
    private static final TransactionManager ourInstance = new TransactionManager();
    private static final ThreadLocal<ConnectionProxy> Connection = new ThreadLocal<>();
    private final DataSource dataSource = DataSource.getInstance();
    private static final Logger LOGGER = LogManager.getLogger();


    public static TransactionManager getInstance() {
        return ourInstance;
    }

    private TransactionManager() {
    }

    private ConnectionProxy createConnection() {

        if (Connection.get() != null) {
            return Connection.get();
        }

        Connection.set(new ConnectionProxy(dataSource.getConnection()));
        Connection.get().setTransactionStatus(true);

        try {
            Connection.get().setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.error("Some problem was occurred with Data base" + e);
        }

        return Connection.get();
    }

    public ConnectionProxy getConnection() {

        if (Connection.get() == null) {
            return new ConnectionProxy(dataSource.getConnection());
        } else {
            return createConnection();
        }

    }

    public void startTransaction() {

        if (Connection.get() != null) {
            throw new IllegalStateException();
        }
        createConnection();
    }

    public void commit() {

        if (Connection.get() == null) {
            throw new IllegalStateException();
        }

        Connection.get().setTransactionStatus(false);

        try {
            Connection.get().commit();
        } catch (SQLException e) {
            LOGGER.error("Some problem was occurred with Data base" + e);
            try {
                LOGGER.error("Transaction is being rolled back");
                Connection.get().rollback();
            } catch (SQLException e1) {
                LOGGER.error("Failed to rollback Transaction \n" + e1);
            }
        } finally {
            try {
                Connection.get().setAutoCommit(true);
                Connection.get().close();
            } catch (SQLException e) {
                LOGGER.error("Some problem was occurred with Data base" + e);
            }
        }

        Connection.set(null);
    }
}
