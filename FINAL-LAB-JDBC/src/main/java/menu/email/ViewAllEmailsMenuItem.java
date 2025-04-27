package menu.email;

import dao.EmailDAO;
import entity.Email;
import menu.NamedMenuItem;

import java.sql.SQLException;
import java.util.List;

public class ViewAllEmailsMenuItem extends NamedMenuItem {
    private final EmailDAO emailDAO = EmailDAO.getInstance();

    public ViewAllEmailsMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            List<Email> emails = emailDAO.getAllEmails();
            System.out.println("Все email'ы:");
            for (Email email : emails) {
                System.out.println("Email: " + email.getEmail() + ", ID контактного лица: " + email.getContact_person_id());
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при получении email'ов: " + e.getMessage());
        }

        return true;
    }
}
