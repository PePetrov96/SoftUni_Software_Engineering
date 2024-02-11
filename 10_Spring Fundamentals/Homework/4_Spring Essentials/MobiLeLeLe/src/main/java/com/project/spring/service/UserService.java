package com.project.spring.service;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.User;

import java.util.List;

public interface UserService {
    List<String> registerUser(UserDTO userDTO);
    User authenticate(UserDTO userDTO);
}
