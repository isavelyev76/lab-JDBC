package dao;

import entity.Customer;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static final CustomerDAO INSTANCE = new CustomerDAO();
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE id = ?;";
    private static final String ADD_NEW_CUSTOMER = "INSERT INTO customer (name, legal_address, bank_details)" +
                                                "VALUES (?, ?, ?);";
    private static final String GET_ALL_CUSTOMER = "SELECT * FROM customer;";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET name = ?, legal_address = ?, bank_details = ? WHERE id = ?;";
    private CustomerDAO(){
    }

    public void updateCustomer(int id, String name, String legal_address, int bank_details) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, legal_address);
        preparedStatement.setInt(3, bank_details);
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
    }
    public void deleteCustomer(int id) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
    public void addNewCustomer(String name, String legal_address, int bank_details) throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW_CUSTOMER, PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, legal_address);
        preparedStatement.setInt(3, bank_details);
        preparedStatement.executeUpdate();
    }
    public List<Customer> getAllCustomers() throws SQLException {
        Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Customer> customers = new ArrayList<>();
        Customer customer;
        while (resultSet.next()) {
            customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setName(resultSet.getString("name"));
            customer.setLegal_address(resultSet.getString("legal_address"));
            customer.setBank_details(resultSet.getInt("bank_details"));

            customers.add(customer);
        }

        return customers;
    }
    public static CustomerDAO getInstance(){
        return INSTANCE;
    }
}
