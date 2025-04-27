package menu.customer;

import dao.CustomerDAO;
import entity.Customer;
import menu.NamedMenuItem;

import java.sql.SQLException;
import java.util.List;

public class ViewAllCustomersMenuItem extends NamedMenuItem {

    private final CustomerDAO customerDAO = CustomerDAO.getInstance();

    public ViewAllCustomersMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            List<Customer> customers = customerDAO.getAllCustomers();

            if (customers.isEmpty()) {
                System.out.println("Список клиентов пуст.");
            } else {
                for (Customer customer : customers) {
                    System.out.println("ID: " + customer.getId());
                    System.out.println("Название: " + customer.getName());
                    System.out.println("Юридический адрес: " + customer.getLegal_address());
                    System.out.println("Банковские реквизиты: " + customer.getBank_details());
                    System.out.println("-------------------------");
                }
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка клиентов: " + e.getMessage());
        }

        return true; // возвращаем true, чтобы продолжить работу
    }
}
