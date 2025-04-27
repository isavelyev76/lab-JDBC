package dao;

import entity.User;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final UserDAO INSTANCE = new UserDAO();
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?;";
    private static final String ADD_NEW_USER = "INSERT INTO users (id, login, password, role)" +
                                                "VALUES (?, ?, ?, ?);";
    private static final String GET_ALL_USERS = "SELECT * FROM users;";
    private static final String UPDATE_USER = "UPDATE users SET login = ?, password = ?, role = ? WHERE id = ?;";
    private UserDAO(){
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
    public void addNewUser(int id, String login, String password, short role) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_USER);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, login);
        preparedStatement.setString(3, password);
        preparedStatement.setShort(4, role);
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
    public static UserDAO getInstance(){
        return INSTANCE;
    }
}
