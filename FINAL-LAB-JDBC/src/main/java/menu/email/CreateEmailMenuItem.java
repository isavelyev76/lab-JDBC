package menu.email;

import dao.EmailDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class CreateEmailMenuItem extends NamedMenuItem {
    private final EmailDAO emailDAO = EmailDAO.getInstance();

    public CreateEmailMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите email: ");
            String email = console.nextLine();

            System.out.print("Введите ID контактного лица: ");
            int contactPersonId = Integer.parseInt(console.nextLine());

            emailDAO.addNewEmail(email, contactPersonId);

            System.out.println("Email успешно добавлен!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении email: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
