package entities;

import manager.EntityManager;

import java.time.LocalDate;

@EntityManager.Entity(name = "users")
public class User {

    @EntityManager.Id
    private long id;

    @EntityManager.Column(name = "user_name")
    private String user_name;

    @EntityManager.Column(name = "age")
    private int age;

    @EntityManager.Column(name = "registration_date")
    private LocalDate registration_date;

    @Override
    public String toString() {
        return String.format("%s %s", this.user_name, this.registration_date);
    }

    public User(String user_name, int age, LocalDate registration_date) {
        this.user_name = user_name;
        this.age = age;
        this.registration_date = registration_date;
    }

    public User() {

    }

    private void setId(long id) {
        this.id = id;
    }

    private void setUsername(String user_name) {
        this.user_name = user_name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setRegistration(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return user_name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getRegistration() {
        return registration_date;
    }
}