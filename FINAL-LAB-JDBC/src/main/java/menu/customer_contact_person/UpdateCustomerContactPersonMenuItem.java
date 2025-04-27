package menu.customer_contact_person;

import dao.CustomerContactPersonDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class UpdateCustomerContactPersonMenuItem extends NamedMenuItem {

    private final CustomerContactPersonDAO contactPersonDAO = CustomerContactPersonDAO.getInstance();

    public UpdateCustomerContactPersonMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите ID контактного лица для обновления: ");
            int id = Integer.parseInt(console.nextLine());

            System.out.print("Введите имя контактного лица: ");
            String name = console.nextLine();

            System.out.print("Введите фамилию контактного лица: ");
            String surname = console.nextLine();

            System.out.print("Введите отчество контактного лица: ");
            String patronymic = console.nextLine();

            System.out.print("Введите ID заказчика: ");
            int customerId = Integer.parseInt(console.nextLine());

            contactPersonDAO.updateCustomer(id, name, surname, patronymic, customerId);

            System.out.println("Контактное лицо успешно обновлено!");

        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении контактного лица: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
