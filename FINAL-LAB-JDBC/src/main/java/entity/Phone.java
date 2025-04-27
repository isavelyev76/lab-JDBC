package entity;

public class Phone {
    private String number;
    private int contact_person_id;

    public Phone(String number, int contact_person_id) {
        this.number = number;
        this.contact_person_id = contact_person_id;
    }

    public Phone() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getContact_person_id() {
        return contact_person_id;
    }

    public void setContact_person_id(int contact_person_id) {
        this.contact_person_id = contact_person_id;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", contact_person_id=" + contact_person_id +
                '}';
    }
}
