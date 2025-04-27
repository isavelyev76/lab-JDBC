package menu.email;

import dao.EmailDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class UpdateEmailMenuItem extends NamedMenuItem {
    private final EmailDAO emailDAO = EmailDAO.getInstance();

    public UpdateEmailMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите email для обновления: ");
            String email = console.nextLine();

            System.out.print("Введите новый ID контактного лица: ");
            int contactPersonId = Integer.parseInt(console.nextLine());

            emailDAO.updateEmail(email, contactPersonId);

            System.out.println("Email успешно обновлён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении email: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
