package com.example.gamestore.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games;
    @Column(name = "is_administrator")
    private boolean administrator;

    public BaseUser() {
    }

    public BaseUser(String email, String password, String fullName,
                    boolean administrator) {
        setEmail(email);
        setPassword(password);
        setFullName(fullName);
        this.games = new HashSet<>();
        this.administrator = administrator;
    }

    public void buyGame(Game game) {
        this.games.add(game);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Invalid email");
        }

        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$") ||
                password.length() < 6) {
            throw new IllegalArgumentException("Invalid password");
        }

        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}