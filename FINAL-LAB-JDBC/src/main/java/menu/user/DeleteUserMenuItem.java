package menu.user;

import dao.UserDAO;
import menu.NamedMenuItem;

import java.sql.SQLException;

public class DeleteUserMenuItem extends NamedMenuItem {

    private final UserDAO userDAO = UserDAO.getInstance();

    public DeleteUserMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            System.out.print("Введите id пользователя для удаления: ");
            int id = Integer.parseInt(console.nextLine());

            userDAO.deleteUser(id);

            System.out.println("Пользователь успешно удалён!");

        } catch (SQLException e) {
            System.out.println("Ошибка при удалении пользователя: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода числа: " + e.getMessage());
        }

        return true;
    }
}
