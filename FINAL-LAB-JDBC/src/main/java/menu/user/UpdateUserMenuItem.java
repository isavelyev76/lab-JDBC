package menu.user;

import dao.UserDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class UpdateUserMenuItem extends NamedMenuItem {

    private final UserDAO userDAO = UserDAO.getInstance();

    public UpdateUserMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите id пользователя для изменения: ");
            int id = Integer.parseInt(console.nextLine());

            System.out.print("Введите новый логин пользователя: ");
            String login = console.nextLine();

            System.out.print("Введите новый пароль пользователя: ");
            String password = console.nextLine();

            System.out.print("Введите новую роль пользователя (число): ");
            short role = Short.parseShort(console.nextLine());

            userDAO.updateUser(id, login, password, role);

            System.out.println("Пользователь успешно обновлён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении пользователя: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
