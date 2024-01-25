package com.project.spring.service.impl;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.User;
import com.project.spring.repository.UserRepository;
import com.project.spring.service.UserService;
import com.project.spring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validator, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void registerUser(UserDTO userDTO) {
        if (validator.isValid(userDTO)) {
            try {
                this.userRepository.saveAndFlush(mapUser(userDTO));

                System.out.println(message(1, userDTO.getUsername()));
            } catch (Exception e) {
                System.out.println(message(2, e.getLocalizedMessage()));
            }
        } else {
            System.out.println(message(3, ""));
        }
    }

    @Override
    public User authenticate(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        Optional<User> optionalUser = this.userRepository.findUserByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (this.passwordEncoder.matches(password, user.getPassword())) {
                System.out.println(message(4, user.getUsername()));
                return user;
            } else {
                System.out.println(message(5, ""));
            }

        } else {
            System.out.println(message(6,""));
        }
        return null;
    }

    private User mapUser(UserDTO userDTO) {
        User user = this.mapper.map(userDTO, User.class);
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setActive(true);
        return user;
    }

    private String message(int code, String text) {
        return switch (code) {
            case 1 -> String.format("User %s has successfully registered!", text);
            case 2 -> String.format("Cannot save User: " + text);
            case 3 -> "Invalid User";
            case 4 -> String.format("User %s has successfully logged in!", text);
            case 5 -> "Invalid password";
            case 6 -> "User not found";
            default -> null;
        };
    }
}