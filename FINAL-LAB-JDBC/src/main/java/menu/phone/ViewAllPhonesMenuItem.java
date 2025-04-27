package menu.phone;

import dao.PhoneDAO;
import entity.Phone;
import menu.NamedMenuItem;

import java.sql.SQLException;
import java.util.List;

public class ViewAllPhonesMenuItem extends NamedMenuItem {
    private final PhoneDAO phoneDAO = PhoneDAO.getInstance();

    public ViewAllPhonesMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        try {
            List<Phone> phones = phoneDAO.getAllPhones();
            System.out.println("Все телефоны:");
            for (Phone phone : phones) {
                System.out.println("Номер: " + phone.getNumber() + ", ID контактного лица: " + phone.getContact_person_id());
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при получении телефонов: " + e.getMessage());
        }

        return true;
    }
}
