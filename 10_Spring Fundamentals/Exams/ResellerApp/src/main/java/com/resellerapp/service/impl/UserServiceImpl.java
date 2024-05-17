package com.resellerapp.service.impl;

import com.resellerapp.model.dto.UserRegisterDTO;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import com.resellerapp.vallidation.InvalidCredentialsException;
import com.resellerapp.vallidation.InvalidRegisterException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterDTO newUser) {
        if (this.userRepository.findUserByUsername(newUser.getUsername()) != null) {
            throw new InvalidRegisterException("User already exists");
        }

        if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            throw new InvalidRegisterException("Passwords do not match");
        }

        String encodedPassword = passwordEncoder.encode(newUser.getPassword());

        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(encodedPassword);
        user.setEmail(newUser.getEmail());

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User loginUser (String username, String password) {
        User user = this.userRepository.findUserByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException("Incorrect username or password!");
        }
        return user;
    }

    @Override
    public User getUserWithInitializedCollections(String username) {
        User user = this.userRepository.findUserByUsername(username);
        if (user != null) {
            Hibernate.initialize(user.getOffers());
            Hibernate.initialize(user.getBoughtOffers());
        }
        return user;
    }
}
