import dao.AllTablesDAO;
import dao.UserDAO;
import org.postgresql.Driver;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String drop_table_users = "DROP TABLE users";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class<Driver> driverClass = Driver.class;
            connection = ConnectionManager.open();

            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
