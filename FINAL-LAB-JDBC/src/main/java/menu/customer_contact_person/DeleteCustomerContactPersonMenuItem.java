package menu.customer_contact_person;

import dao.CustomerContactPersonDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class DeleteCustomerContactPersonMenuItem extends NamedMenuItem {

    private final CustomerContactPersonDAO contactPersonDAO = CustomerContactPersonDAO.getInstance();

    public DeleteCustomerContactPersonMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите ID контактного лица для удаления: ");
            int id = Integer.parseInt(console.nextLine());

            contactPersonDAO.deleteCustomer(id);

            System.out.println("Контактное лицо успешно удалено!");

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении контактного лица: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
