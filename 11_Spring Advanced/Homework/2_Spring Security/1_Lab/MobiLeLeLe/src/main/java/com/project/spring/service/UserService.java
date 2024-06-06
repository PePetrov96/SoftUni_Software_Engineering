package com.project.spring.service;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<String> registerUser(UserDTO userDTO);
    UserEntity authenticate(UserDTO userDTO);
}
