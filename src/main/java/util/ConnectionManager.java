package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

    public ConnectionManager() {
    }

    public static Connection open(){
        try {
            return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY),
                    PropertiesUtil.getProperty(USER_KEY),
                    PropertiesUtil.getProperty(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
