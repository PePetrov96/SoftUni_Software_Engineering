package entities;

import manager.EntityManager;

import java.time.LocalDate;

@EntityManager.Entity(name = "users")
public class User {

    @EntityManager.Id
    private long id;

    @EntityManager.Column(name = "user_name")
    private String username;

    @EntityManager.Column(name = "age")
    private int age;

    @EntityManager.Column(name = "registration_date")
    private LocalDate registration;

    @Override
    public String toString() {
        return String.format("%s %s", this.username, this.registration);
    }

    public User(String username, int age, LocalDate registration) {
        this.username = username;
        this.age = age;
        this.registration = registration;
    }

    public User() {

    }

    private void setId(long id) {
        this.id = id;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getRegistration() {
        return registration;
    }
}