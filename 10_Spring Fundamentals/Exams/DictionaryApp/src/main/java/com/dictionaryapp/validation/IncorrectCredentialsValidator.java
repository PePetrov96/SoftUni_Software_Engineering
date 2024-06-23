package com.dictionaryapp.validation;


import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class IncorrectCredentialsValidator implements ConstraintValidator<IncorrectCredentials, UserLoginDTO> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public IncorrectCredentialsValidator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initialize(IncorrectCredentials constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserLoginDTO userLoginDTO, ConstraintValidatorContext context) {
        Optional<User> user = this.userRepository.findUserByUsername(userLoginDTO.getUsername());
        return user.isPresent() && passwordEncoder.matches(userLoginDTO.getPassword(), user.get().getPassword());
    }
}
