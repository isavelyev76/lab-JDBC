package menu.customer;

import dao.CustomerDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class UpdateCustomerMenuItem extends NamedMenuItem {

    private final CustomerDAO customerDAO = CustomerDAO.getInstance();

    public UpdateCustomerMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите id клиента для обновления: ");
            int id = Integer.parseInt(console.nextLine());

            System.out.print("Введите новое название клиента: ");
            String name = console.nextLine();

            System.out.print("Введите новый юридический адрес клиента: ");
            String legalAddress = console.nextLine();

            System.out.print("Введите новые банковские реквизиты клиента: ");
            int bankDetails = Integer.parseInt(console.nextLine());

            customerDAO.updateCustomer(id, name, legalAddress, bankDetails);

            System.out.println("Информация о клиенте успешно обновлена!");

        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении клиента: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода данных: " + e.getMessage());
        }

        return true; // возвращаем true, чтобы продолжить работу
    }
}
