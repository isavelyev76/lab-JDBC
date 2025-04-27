package entity;

public class CustomersContactPerson {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private int customer_id;

    public CustomersContactPerson(int id, String name, String surname, String patronymic, int customer_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.customer_id = customer_id;
    }
    public CustomersContactPerson(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "CustomersContactPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }
}
