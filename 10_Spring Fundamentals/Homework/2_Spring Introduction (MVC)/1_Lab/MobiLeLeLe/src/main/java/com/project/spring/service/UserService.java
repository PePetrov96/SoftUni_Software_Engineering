package com.project.spring.service;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.User;

public interface UserService {
    void registerUser(UserDTO userDTO);
    User authenticate(UserDTO userDTO);
}
