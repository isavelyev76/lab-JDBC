package menu.customer;

import dao.CustomerDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class DeleteCustomerMenuItem extends NamedMenuItem {

    private final CustomerDAO customerDAO = CustomerDAO.getInstance();

    public DeleteCustomerMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите id клиента для удаления: ");
            int id = Integer.parseInt(console.nextLine());

            customerDAO.deleteCustomer(id);

            System.out.println("Клиент успешно удалён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении клиента: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true; // возвращаем true, чтобы продолжить работу
    }
}
