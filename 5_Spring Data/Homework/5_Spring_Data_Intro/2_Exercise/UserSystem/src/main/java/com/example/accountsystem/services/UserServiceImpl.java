package com.example.accountsystem.services;

import com.example.accountsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.accountsystem.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository
                .findUserByUsername(username)
                .orElse(null);
    }
}