package menu.customer_contact_person;

import dao.CustomerContactPersonDAO;
import entity.CustomersContactPerson;
import menu.NamedMenuItem;

import java.sql.SQLException;
import java.util.List;

public class ViewCustomerContactPersonsMenuItem extends NamedMenuItem {

    private final CustomerContactPersonDAO contactPersonDAO = CustomerContactPersonDAO.getInstance();

    public ViewCustomerContactPersonsMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите ID заказчика для просмотра контактных лиц: ");
            int customerId = Integer.parseInt(console.nextLine());

            List<CustomersContactPerson> contactPersons = contactPersonDAO.getAllCustomersWithContactDetails(customerId);

            if (contactPersons.isEmpty()) {
                System.out.println("Нет контактных лиц для данного заказчика.");
            } else {
                System.out.println("Контактные лица:");
                for (CustomersContactPerson contactPerson : contactPersons) {
                    System.out.println(contactPerson);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при получении контактных лиц: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
