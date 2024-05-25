package com.plannerapp.service;

import com.plannerapp.model.dto.UserLoginBindingModel;
import com.plannerapp.model.dto.UserRegisterBindingModel;
import com.plannerapp.model.entity.User;

public interface UserService {
    void registerUser(UserRegisterBindingModel userRegisterBindingModel);
    User loginUser(UserLoginBindingModel userLoginBindingModel);
    User getUser(String username);
}
