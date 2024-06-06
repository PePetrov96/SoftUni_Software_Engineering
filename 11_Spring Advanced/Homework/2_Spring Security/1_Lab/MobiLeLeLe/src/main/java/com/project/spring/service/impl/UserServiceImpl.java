package com.project.spring.service.impl;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.UserEntity;
import com.project.spring.models.entity.UserRoleEntity;
import com.project.spring.models.entity.enums.UserRolesEnum;
import com.project.spring.repository.UserRepository;
import com.project.spring.repository.UserRoleRepository;
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
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validator, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
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
    public UserEntity authenticate(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        Optional<UserEntity> optionalUser = this.userRepository.findUserByUsername(username);

        if (optionalUser.isPresent()) {
            UserEntity userEntity = optionalUser.get();

            if (this.passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
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

    private UserEntity mapUser(UserDTO userDTO) {
        UserEntity userEntity = this.mapper.map(userDTO, UserEntity.class);
        userEntity.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setCreated(LocalDateTime.now());
        userEntity.setModified(LocalDateTime.now());
        userEntity.setActive(true);
        userEntity.setRoles(mapToUserRoles(userDTO.getRole()));
        return userEntity;
    }

    private List<UserRoleEntity> mapToUserRoles(String role) {
        List<UserRoleEntity> userRoleEntities = new ArrayList<>();

        if (role.equals("ADMIN")) {
            UserRolesEnum userRolesEnumADMIN = UserRolesEnum.ADMIN;
            UserRolesEnum userRolesEnumUSER = UserRolesEnum.USER;

            UserRoleEntity userRoleEntityADMIN = userRoleRepository.findUserRoleByRole(userRolesEnumADMIN);
            UserRoleEntity userRoleUSEREntity = userRoleRepository.findUserRoleByRole(userRolesEnumUSER);

            userRoleEntities.add(userRoleEntityADMIN);
            userRoleEntities.add(userRoleUSEREntity);
        } else {
            UserRolesEnum userRolesEnumUSER = UserRolesEnum.USER;

            UserRoleEntity userRoleUSEREntity = userRoleRepository.findUserRoleByRole(userRolesEnumUSER);

            userRoleEntities.add(userRoleUSEREntity);
        }

        return userRoleEntities;
    }
}