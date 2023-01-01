package org.example.connector;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:mem://localhost/~/mvc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1";
    public static final int MAX_POOL_SIZE = 30;
    public static final int IDLE_TIMEOUT_MS = 50;

    private static final DataSource ds;
    
    // Connection Pool 적용해 connection 받아옴
    static {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DB_DRIVER);
        hikariDataSource.setJdbcUrl(DB_URL);
        hikariDataSource.setUsername("sa");
        hikariDataSource.setPassword("");

        // Maximum pool-size
        hikariDataSource.setMaximumPoolSize(MAX_POOL_SIZE);

        // Minimum idle timeout ms
        hikariDataSource.setIdleTimeout(IDLE_TIMEOUT_MS);

        ds = hikariDataSource;
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch(SQLException e){
            throw new IllegalArgumentException(e);
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
