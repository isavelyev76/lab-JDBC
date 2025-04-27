package entity;

public class Email {
    private String email;
    private int contact_person_id;

    public Email(String email, int contact_person_id) {
        this.email = email;
        this.contact_person_id = contact_person_id;
    }

    public Email() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact_person_id() {
        return contact_person_id;
    }

    public void setContact_person_id(int contact_person_id) {
        this.contact_person_id = contact_person_id;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", contact_person_id=" + contact_person_id +
                '}';
    }
}
