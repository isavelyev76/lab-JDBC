package menu.user;

import dao.UserDAO;
import entity.User;
import menu.NamedMenuItem;

import java.sql.SQLException;
import java.util.List;

public class ReadAllUsersMenuItem extends NamedMenuItem {

    private final UserDAO userDAO = UserDAO.getInstance();

    public ReadAllUsersMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            List<User> users = userDAO.getAllUsers();

            if (users.isEmpty()) {
                System.out.println("Пользователи отсутствуют в базе данных.");
            } else {
                System.out.println("Список пользователей:");
                for (User user : users) {
                    System.out.println(user);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка пользователей: " + e.getMessage());
        }

        return true;
    }
}
