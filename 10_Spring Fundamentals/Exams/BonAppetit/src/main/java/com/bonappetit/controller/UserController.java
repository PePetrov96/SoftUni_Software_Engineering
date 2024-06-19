package com.bonappetit.controller;

import com.bonappetit.model.dto.UserLoginDTO;
import com.bonappetit.model.dto.UserRegisterDTO;
import com.bonappetit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.bonappetit.util.Constants.*;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(LOGIN_URL)
    public String showLoginPage(Model model, HttpSession httpSession) {
        return this.userService.showLoginPage(model, httpSession);
    }

    @PostMapping(LOGIN_URL)
    public String loginUserHandler(@Valid @ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO,
                                   BindingResult bindingResult, HttpSession httpSession) {
        return this.userService.handleLoginUser(userLoginDTO, bindingResult, httpSession);
    }

    @GetMapping(REGISTER_URL)
    public String showRegisterPage(Model model, HttpSession httpSession) {
        return this.userService.showRegisterPage(model, httpSession);
    }

    @PostMapping(REGISTER_URL)
    public String registerUserHandler(@Valid @ModelAttribute("userRegisterDTO") UserRegisterDTO userRegisterDTO,
                                      BindingResult bindingResult) {
        return this.userService.handleRegisterUser(userRegisterDTO, bindingResult);
    }

    @GetMapping(LOGOUT_URL)
    public String logoutUserHandler(HttpSession httpSession) {
        return this.userService.handleLogoutUser(httpSession);
    }
}
