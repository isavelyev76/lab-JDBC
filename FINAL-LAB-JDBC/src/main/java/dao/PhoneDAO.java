package dao;

import entity.Phone;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {
    private static final PhoneDAO INSTANCE = new PhoneDAO();
    private static final String DELETE_PHONE = "DELETE FROM phone WHERE number = ?;";
    private static final String ADD_NEW_PHONE = "INSERT INTO phone (number, contact_person_id) VALUES (?, ?);";
    private static final String GET_ALL_PHONES = "SELECT * FROM phone;";
    private static final String UPDATE_PHONE = "UPDATE phone SET contact_person_id = ? WHERE number = ?;";

    private PhoneDAO() {
    }

    public void updatePhone(String number, int contact_person_id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHONE);
        preparedStatement.setInt(1, contact_person_id);
        preparedStatement.setString(2, number);
        preparedStatement.executeUpdate();
    }

    public void deletePhone(String number) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PHONE);
        preparedStatement.setString(1, number);
        preparedStatement.executeUpdate();
    }

    public void addNewPhone(String number, int contact_person_id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_PHONE, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, number);
        preparedStatement.setInt(2, contact_person_id);
        preparedStatement.executeUpdate();
    }

    public List<Phone> getAllPhones() throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PHONES);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Phone> phones = new ArrayList<>();
        while (resultSet.next()) {
            Phone phone = new Phone();
            phone.setNumber(resultSet.getString("number"));
            phone.setContact_person_id(resultSet.getInt("contact_person_id"));
            phones.add(phone);
        }
        return phones;
    }

    public static PhoneDAO getInstance() {
        return INSTANCE;
    }
}
