package dao;

import entity.User;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final UserDAO INSTANCE = new UserDAO();
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?;";
    private static final String ADD_NEW_USER = "INSERT INTO users (login, password, role) VALUES (?, ?, ?);";
    private static final String GET_ALL_USERS = "SELECT * FROM users;";
    private static final String UPDATE_USER = "UPDATE users SET login = ?, password = ?, role = ? WHERE id = ?;";

    private UserDAO() {
    }

    public void updateUser(int id, String login, String password, short role) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setInt(3, role);
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
    }

    public void deleteUser(int id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void addNewUser(String login, String password, short role) throws SQLException {
        Connection connection = ConnectionManager.open();
        Statement statement = connection.createStatement();
        statement.execute("SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));");
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(ADD_NEW_USER, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setShort(3, role);

        preparedStatement.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<User> users = new ArrayList<>();
        User user;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getShort("role"));

            users.add(user);
        }

        return users;
    }

    public static UserDAO getInstance() {
        return INSTANCE;
    }
}
