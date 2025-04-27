package dao;

import entity.Email;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAO {
    private static final EmailDAO INSTANCE = new EmailDAO();
    private static final String DELETE_EMAIL = "DELETE FROM email WHERE email = ?;";
    private static final String ADD_NEW_EMAIL = "INSERT INTO email (email, contact_person_id) VALUES (?, ?);";
    private static final String GET_ALL_EMAILS = "SELECT * FROM email;";
    private static final String UPDATE_EMAIL = "UPDATE email SET contact_person_id = ? WHERE email = ?;";

    private EmailDAO() {
    }

    public void updateEmail(String email, int contact_person_id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMAIL);
        preparedStatement.setInt(1, contact_person_id);
        preparedStatement.setString(2, email);
        preparedStatement.executeUpdate();
    }

    public void deleteEmail(String email) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMAIL);
        preparedStatement.setString(1, email);
        preparedStatement.executeUpdate();
    }

    public void addNewEmail(String email, int contact_person_id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_EMAIL, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, email);
        preparedStatement.setInt(2, contact_person_id);
        preparedStatement.executeUpdate();
    }

    public List<Email> getAllEmails() throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_EMAILS);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Email> emails = new ArrayList<>();
        while (resultSet.next()) {
            Email email = new Email();
            email.setEmail(resultSet.getString("email"));
            email.setContact_person_id(resultSet.getInt("contact_person_id"));
            emails.add(email);
        }
        return emails;
    }

    public static EmailDAO getInstance() {
        return INSTANCE;
    }
}
