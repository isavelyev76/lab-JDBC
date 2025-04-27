package menu.email;

import dao.EmailDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class DeleteEmailMenuItem extends NamedMenuItem {
    private final EmailDAO emailDAO = EmailDAO.getInstance();

    public DeleteEmailMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите email для удаления: ");
            String email = console.nextLine();

            emailDAO.deleteEmail(email);

            System.out.println("Email успешно удалён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении email: " + e.getMessage());
        }

        return true;
    }
}
