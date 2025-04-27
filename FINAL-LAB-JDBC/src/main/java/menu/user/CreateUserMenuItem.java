package menu.user;

import dao.UserDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class CreateUserMenuItem extends NamedMenuItem {

    private final UserDAO userDAO = UserDAO.getInstance();

    public CreateUserMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите логин пользователя: ");
            String login = console.nextLine();

            System.out.print("Введите пароль пользователя: ");
            String password = console.nextLine();

            System.out.print("Введите роль пользователя (число): ");
            short role = Short.parseShort(console.nextLine());

            userDAO.addNewUser(login, password, role);

            System.out.println("Пользователь успешно добавлен!");

        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении пользователя: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
