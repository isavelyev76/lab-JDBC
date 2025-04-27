package menu.phone;

import dao.PhoneDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class CreatePhoneMenuItem extends NamedMenuItem {
    private final PhoneDAO phoneDAO = PhoneDAO.getInstance();

    public CreatePhoneMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите номер телефона: ");
            String number = console.nextLine();

            System.out.print("Введите ID контактного лица: ");
            int contactPersonId = Integer.parseInt(console.nextLine());

            phoneDAO.addNewPhone(number, contactPersonId);

            System.out.println("Телефон успешно добавлен!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении телефона: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
