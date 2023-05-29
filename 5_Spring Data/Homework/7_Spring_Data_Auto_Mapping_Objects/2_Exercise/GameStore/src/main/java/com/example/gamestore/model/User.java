package com.example.gamestore.model;

import jakarta.persistence.Entity;

@Entity
public class User extends BaseUser {
    private static final boolean IS_NOT_ADMIN = false;

    public User() {
    }

    public User(String email, String password, String fullName) {
        super(email, password, fullName, IS_NOT_ADMIN);
    }
}