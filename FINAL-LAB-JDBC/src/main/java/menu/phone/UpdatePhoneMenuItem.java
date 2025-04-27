package menu.phone;

import dao.PhoneDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class UpdatePhoneMenuItem extends NamedMenuItem {
    private final PhoneDAO phoneDAO = PhoneDAO.getInstance();

    public UpdatePhoneMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите номер телефона для обновления: ");
            String number = console.nextLine();

            System.out.print("Введите новый ID контактного лица: ");
            int contactPersonId = Integer.parseInt(console.nextLine());

            phoneDAO.updatePhone(number, contactPersonId);

            System.out.println("Телефон успешно обновлён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении телефона: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
