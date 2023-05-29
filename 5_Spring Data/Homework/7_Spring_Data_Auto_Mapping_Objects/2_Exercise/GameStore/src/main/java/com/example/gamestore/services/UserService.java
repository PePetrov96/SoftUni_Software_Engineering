package com.example.gamestore.services;

import com.example.gamestore.model.Administrator;
import com.example.gamestore.model.BaseUser;
import com.example.gamestore.model.Game;
import com.example.gamestore.model.User;

import java.util.Set;

public interface UserService {
    void create(String[] data);
    boolean userExists(String email);
    BaseUser findByUsernameAndPassword(String email, String password);
    Administrator findAdmin();
    void buyGames(Set<Game> shoppingCart, BaseUser loggedUser);
}
