package com.resellerapp.service;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegisterDTO;
import com.resellerapp.model.dto.UserViewDTO;
import com.resellerapp.model.entity.User;

public interface UserService {
    User loginUser(String username, String password);
    void registerUser(UserRegisterDTO userRegisterDTO);
    User getUserWithInitializedCollections(String username);
}
