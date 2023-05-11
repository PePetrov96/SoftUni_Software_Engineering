package com.example.accountsystem.services;

import com.example.accountsystem.model.User;

public interface UserService {
    void registerUser(User user);
    User findByUsername(String username);
}