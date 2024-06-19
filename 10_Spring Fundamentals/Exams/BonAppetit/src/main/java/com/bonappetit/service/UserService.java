package com.bonappetit.service;

import com.bonappetit.model.dto.UserLoginDTO;
import com.bonappetit.model.dto.UserRegisterDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

public interface UserService {
     String showLoginPage(Model model, HttpSession httpSession);
     String handleLoginUser(UserLoginDTO userLoginDTO, BindingResult bindingResult, HttpSession httpSession);
     String showRegisterPage(Model model, HttpSession httpSession);
     String handleRegisterUser(UserRegisterDTO userRegisterDTO, BindingResult bindingResult);
     String handleLogoutUser(HttpSession httpSession);

}
