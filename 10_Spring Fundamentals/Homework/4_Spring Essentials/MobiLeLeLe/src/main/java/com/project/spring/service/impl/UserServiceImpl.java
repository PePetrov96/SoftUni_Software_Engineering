package com.project.spring.service.impl;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.User;
import com.project.spring.repository.UserRepository;
import com.project.spring.service.UserService;
import com.project.spring.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public List<String> registerUser(UserDTO userDTO) {
        if (validator.isValid(userDTO)) {
            if (this.userRepository.findUserByUsername(userDTO.getUsername()).isEmpty()) {
                this.userRepository.saveAndFlush(mapUser(userDTO));
                return null;
            } else {
                return registerErrors(userDTO);
            }
        } else {
            return registerErrors(userDTO);
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
                return user;
            }
        }

        return null;
    }

    private List<String> registerErrors(UserDTO userDTO) {
        Set<ConstraintViolation<UserDTO>> violations = this.validator.violations(userDTO);

        List<String> errors = new ArrayList<>();

        for (ConstraintViolation<UserDTO> violation : violations) {
            errors.add(violation.getMessage());
        }

        if (this.userRepository.findUserByUsername(userDTO.getUsername()).isPresent()) {
            errors.add("usernameExists");
        }

        return errors;
    }

    private User mapUser(UserDTO userDTO) {
        User user = this.mapper.map(userDTO, User.class);
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setActive(true);
        return user;
    }
}