package com.example.gamestore.services.Impl;

import com.example.gamestore.model.Administrator;
import com.example.gamestore.model.BaseUser;
import com.example.gamestore.model.Game;
import com.example.gamestore.model.User;
import com.example.gamestore.repositories.UserRepository;
import com.example.gamestore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void create(String[] data) {
        String email = data[0];
        String password = data[1];
        String confirmPassword = data[2];
        String fullName = data[3];

        Administrator administrator = this.userRepository.findBaseUserByAdministratorIs(true);

        if (this.userRepository.findByEmail(email) != null) {
            System.out.println("User with this email already exists");
            return;
        } else if (!password.equals(confirmPassword)){
            System.out.println("Password, does not match confirm password");
        }

        try {
            if (administrator != null) {
                User user = new User(email, password, fullName);
                this.userRepository.save(user);
                System.out.printf("%s was registered%n", fullName);
            } else {
                Administrator admin = new Administrator(email, password, fullName);
                this.userRepository.save(admin);
                System.out.printf("%s was registered as administrator%n", fullName);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public boolean userExists(String email) {
        return this.userRepository.findByEmail(email) != null;
    }
    @Override
    public BaseUser findByUsernameAndPassword(String email, String password) {
        return this.userRepository.findBaseUserByEmailAndPassword(email, password);
    }
    @Override
    public Administrator findAdmin() {
        return this.userRepository.findBaseUserByAdministratorIs(true);
    }

    @Override
    @Transactional
    public void buyGames(Set<Game> shoppingCart, BaseUser loggedUser) {
        BaseUser user = this.userRepository.findByEmail(loggedUser.getEmail());

        Set<Game> ownedGames = user.getGames();
        ownedGames.addAll(shoppingCart);

        user.setGames(ownedGames);

        this.userRepository.save(user);

        System.out.println("Successfully bought games:");
        for (Game game : shoppingCart) {
            System.out.println(game.getTitle());
        }
    }
}