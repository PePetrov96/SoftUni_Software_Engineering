package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.UserLoginBindingModel;
import com.dictionaryapp.model.dto.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;

public interface UserService {
    void registerUser(UserRegisterBindingModel userRegisterBindingModel);
    User loginUser(UserLoginBindingModel userLoginBindingModel);
}
