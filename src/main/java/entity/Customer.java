package entity;

public class Customer {
    private int id;
    private String name;
    private String legal_address;
    private int bank_details;

    public Customer(int id, String name, String legal_address, int bank_details) {
        this.id = id;
        this.name = name;
        this.legal_address = legal_address;
        this.bank_details = bank_details;
    }
    public Customer(){

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

    public String getLegal_address() {
        return legal_address;
    }

    public void setLegal_address(String legal_address) {
        this.legal_address = legal_address;
    }

    public int getBank_details() {
        return bank_details;
    }

    public void setBank_details(int bank_details) {
        this.bank_details = bank_details;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", legal_address='" + legal_address + '\'' +
                ", bank_details=" + bank_details +
                '}';
    }
}
