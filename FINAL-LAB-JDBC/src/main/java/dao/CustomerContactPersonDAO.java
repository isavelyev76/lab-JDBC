package dao;

import entity.CustomersContactPerson;
import util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerContactPersonDAO {
    private static final CustomerContactPersonDAO INSTANCE = new CustomerContactPersonDAO();
    private static final String DELETE_CUSTOMER_CONTACT_PERSON = "DELETE FROM customers_contact_persons_contact_person WHERE id = ?;";
    private static final String ADD_NEW_CUSTOMER_CONTACT_PERSON = "INSERT INTO customers_contact_person (name, surname, patronymic, customer_id)" +
            "VALUES (?, ?, ?, ?);";
    private static final String GET_CUSTOMER_CONTACT_PERSON_WITH_DETAILS = "SELECT ccp.id, ccp.name, ccp.surname, ccp.patronymic, e.email, p.number\n" +
            "FROM customers_contact_person ccp\n" +
            "FULL JOIN email e ON ccp.id = e.contact_person_id\n" +
            "FULL JOIN phone p ON ccp.id = p.contact_person_id\n" +
            "WHERE ccp.customer_id = ?;\n";
    private static final String UPDATE_CUSTOMER_CONTACT_PERSON = "UPDATE customers_contact_person SET name = ?, surname = ?, patronymic = ?, customer_id = ? WHERE id = ?;";
    private CustomerContactPersonDAO(){
    }

    public void updateCustomer(int id, String name, String surname,String patronymic, int customer_id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_CONTACT_PERSON);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, patronymic);
        preparedStatement.setInt(4, customer_id);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();
    }
    public void deleteCustomer(int id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_CONTACT_PERSON);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public void addNewCustomer(String name, String surname, String patronymic, int customer_id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CUSTOMER_CONTACT_PERSON, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setString(3, patronymic);
        preparedStatement.setInt(4, customer_id);
        preparedStatement.executeUpdate();
    }

    public List<CustomersContactPerson> getAllCustomersWithContactDetails(int customerId) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CUSTOMER_CONTACT_PERSON_WITH_DETAILS);
        preparedStatement.setInt(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<CustomersContactPerson> customersContactPersons = new ArrayList<>();
        while (resultSet.next()) {
            CustomersContactPerson customerContactPerson = new CustomersContactPerson();
            customerContactPerson.setId(resultSet.getInt("id"));
            customerContactPerson.setName(resultSet.getString("name"));
            customerContactPerson.setSurname(resultSet.getString("surname"));
            customerContactPerson.setPatronymic(resultSet.getString("patronymic"));

            String email = resultSet.getString("email");
            String phoneNumber = resultSet.getString("number");

            customerContactPerson.setEmail(email);
            customerContactPerson.setPhone(phoneNumber);

            customersContactPersons.add(customerContactPerson);
        }

        return customersContactPersons;
    }


    public static CustomerContactPersonDAO getInstance(){
        return INSTANCE;
    }
}
