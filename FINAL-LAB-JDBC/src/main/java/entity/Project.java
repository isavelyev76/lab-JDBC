package entity;

import java.time.LocalDate;

public class Project {
    private int id;
    private String name;
    private LocalDate date_of_beginning;
    private LocalDate date_of_ending;
    private int customer_id;

    public Project(int id, String name, LocalDate date_of_beginning, LocalDate date_of_ending, int customer_id) {
        this.id = id;
        this.name = name;
        this.date_of_beginning = date_of_beginning;
        this.date_of_ending = date_of_ending;
        this.customer_id = customer_id;
    }

    public Project() {
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

    public LocalDate getDate_of_beginning() {
        return date_of_beginning;
    }

    public void setDate_of_beginning(LocalDate date_of_beginning) {
        this.date_of_beginning = date_of_beginning;
    }

    public LocalDate getDate_of_ending() {
        return date_of_ending;
    }

    public void setDate_of_ending(LocalDate date_of_ending) {
        this.date_of_ending = date_of_ending;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_of_beginning=" + date_of_beginning +
                ", date_of_ending=" + date_of_ending +
                ", customer_id=" + customer_id +
                '}';
    }
}
