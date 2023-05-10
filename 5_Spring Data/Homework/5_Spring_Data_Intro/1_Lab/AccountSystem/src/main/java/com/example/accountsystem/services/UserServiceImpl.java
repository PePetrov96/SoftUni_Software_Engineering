package com.example.accountsystem.services;

import com.example.accountsystem.model.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.accountsystem.repositories.UserRepository;

import java.security.InvalidParameterException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        if (this.userRepository.findUserByUsername(user.getUsername()).isPresent()) {
            throw new InvalidParameterException("Username is already taken");
        }

        this.userRepository.save(user);
    }
}