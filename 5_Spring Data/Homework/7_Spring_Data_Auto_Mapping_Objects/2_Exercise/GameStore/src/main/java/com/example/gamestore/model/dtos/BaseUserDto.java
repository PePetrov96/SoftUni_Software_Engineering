package com.example.gamestore.model.dtos;

import com.example.gamestore.model.Game;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseUserDto {
    private String email;
    private String password;
    private String fullName;
    private Set<Game> games;
    private boolean administrator;

    public BaseUserDto(String email, String password, String fullName, boolean administrator) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.games = new HashSet<>();
        this.administrator = administrator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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
