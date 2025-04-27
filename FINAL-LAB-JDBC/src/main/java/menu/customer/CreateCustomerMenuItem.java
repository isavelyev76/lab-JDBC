package menu.customer;

import dao.CustomerDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class CreateCustomerMenuItem extends NamedMenuItem {

    private final CustomerDAO customerDAO = CustomerDAO.getInstance();

    public CreateCustomerMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите название клиента: ");
            String name = console.nextLine();

            System.out.print("Введите юридический адрес клиента: ");
            String legalAddress = console.nextLine();

            System.out.print("Введите банковские реквизиты клиента: ");
            int bankDetails = Integer.parseInt(console.nextLine());

            customerDAO.addNewCustomer(name, legalAddress, bankDetails);

            System.out.println("Клиент успешно добавлен!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении клиента: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }

        return true; // возвращаем true, чтобы продолжить работу
    }
}
