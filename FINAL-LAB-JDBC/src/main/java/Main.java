import menu.*;
import menu.customer.*;
import menu.customer_contact_person.*;
import menu.phone.*;
import menu.email.*;
import menu.user.*;
import org.postgresql.Driver;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Class<Driver> driverClass = Driver.class;
            Connection connection = ConnectionManager.open();
            Scanner console = new Scanner(System.in);

            List<MenuItem> menuItems = List.of(
                    new InitTablesMenuItem("Инициализация всех таблиц"),
                    new CreateUserMenuItem("Создание пользователя"),
                    new UpdateUserMenuItem("Изменение пользователя"),
                    new DeleteUserMenuItem("Удаление пользователя"),
                    new ReadAllUsersMenuItem("Просмотр пользователей"),
                    new CreateCustomerMenuItem("Добавить нового клиента"),
                    new DeleteCustomerMenuItem("Удалить клиента"),
                    new UpdateCustomerMenuItem("Обновить информацию о клиенте"),
                    new ViewAllCustomersMenuItem("Просмотреть все клиенты"),
                    new CreateCustomerContactPersonMenuItem("Добавить контактное лицо клиента"),
                    new UpdateCustomerContactPersonMenuItem("Обновить контактное лицо клиента"),
                    new DeleteCustomerContactPersonMenuItem("Удалить контактное лицо клиента"),
                    new ViewCustomerContactPersonsMenuItem("Просмотреть контактные лица клиента"),
                    new CreatePhoneMenuItem("Добавить телефон"),
                    new UpdatePhoneMenuItem("Обновить телефон"),
                    new DeletePhoneMenuItem("Удалить телефон"),
                    new ViewAllPhonesMenuItem("Просмотреть все телефоны"),
                    new CreateEmailMenuItem("Добавить email"),
                    new UpdateEmailMenuItem("Обновить email"),
                    new DeleteEmailMenuItem("Удалить email"),
                    new ViewAllEmailsMenuItem("Просмотреть все email'ы"),
                    new ExitMenuItem("Выход")
            );

            boolean work = true;
            while (work) {
                System.out.println("\n====== МЕНЮ ======");
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println((i + 1) + ") " + menuItems.get(i).title());
                }
                System.out.println("==================");
                System.out.print("\nВаш выбор: ");

                int menuItemIndex;
                try {
                    menuItemIndex = Integer.parseInt(console.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода числа. Попробуйте снова.");
                    continue;
                }

                if (menuItemIndex < 0 || menuItemIndex >= menuItems.size()) {
                    System.out.println("Нет такого пункта меню. Попробуйте снова.");
                    continue;
                }

                MenuItem menuItem = menuItems.get(menuItemIndex);
                work = menuItem.activate();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }
}
