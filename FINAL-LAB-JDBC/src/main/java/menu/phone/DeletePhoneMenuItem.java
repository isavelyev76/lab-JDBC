package menu.phone;

import dao.PhoneDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class DeletePhoneMenuItem extends NamedMenuItem {
    private final PhoneDAO phoneDAO = PhoneDAO.getInstance();

    public DeletePhoneMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите номер телефона для удаления: ");
            String number = console.nextLine();

            phoneDAO.deletePhone(number);

            System.out.println("Телефон успешно удалён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении телефона: " + e.getMessage());
        }

        return true;
    }
}
