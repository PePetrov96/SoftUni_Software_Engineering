package com.bonappetit.vallidation;

import com.bonappetit.model.dto.UserLoginDTO;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
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
