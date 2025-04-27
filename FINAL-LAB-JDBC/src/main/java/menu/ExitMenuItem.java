package menu;

import java.util.Set;

public class ExitMenuItem extends NamedMenuItem {
    public ExitMenuItem(String title) {
        super(title);
    }

    public boolean activate() {
        System.out.print("\nВы действительно хотите завершить работу? (y/n/д/н): ");
        if(Set.of("y", "yes", "д", "да").contains(console.nextLine().trim().toLowerCase())) {
            System.out.println("До свидания");
            return false;
        }
        return true;
    }
}