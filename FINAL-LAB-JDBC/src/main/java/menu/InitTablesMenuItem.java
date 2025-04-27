package menu;

import dao.AllTablesDAO;

public class InitTablesMenuItem extends NamedMenuItem {

    public InitTablesMenuItem(String title) {
        super(title);
    }

    @Override
    public boolean activate() {
        if (!AllTablesDAO.isAlreadySet) {
            AllTablesDAO.setAllTables();
            AllTablesDAO.isAlreadySet = true;
            System.out.println("Все таблицы успешно инициализированы!");
        } else {
            System.out.println("Таблицы уже были инициализированы ранее.");
        }
        return true; // возвращаем true, чтобы не выходить из программы
    }
}
