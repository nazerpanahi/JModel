package db.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection(String driver, String url, String user, String password) throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(driver);
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            connection = DriverManager.getConnection(url, properties);
        }
        return connection;
    }

    public void setLogWriter(PrintWriter w) {
        DriverManager.setLogWriter(w);
    }
}
