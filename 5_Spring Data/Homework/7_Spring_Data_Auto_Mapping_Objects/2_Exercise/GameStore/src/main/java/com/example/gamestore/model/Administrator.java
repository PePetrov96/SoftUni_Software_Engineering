package com.example.gamestore.model;

import jakarta.persistence.Entity;

@Entity
public class Administrator extends BaseUser {
    private static final boolean IS_ADMIN = true;

    public Administrator() {
    }

    public Administrator(String email, String password, String fullName) {
        super(email, password, fullName, IS_ADMIN);
    }
}
