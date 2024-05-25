package com.plannerapp.controller;

import com.plannerapp.model.dto.UserLoginBindingModel;
import com.plannerapp.model.dto.UserRegisterBindingModel;
import com.plannerapp.model.entity.User;
import com.plannerapp.service.UserService;
import com.plannerapp.vallidation.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginPost(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            User user = this.userService.loginUser(userLoginBindingModel);
            session.setAttribute("user", user);
            return "redirect:/home";
        } catch (Exception e) {
            bindingResult.rejectValue("username", "error.userLoginBinding", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegisterPost(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            this.userService.registerUser(userRegisterBindingModel);
            return "redirect:/user/login";
        } catch (UserAlreadyExistsException e) {
            bindingResult.rejectValue("username", "error.userRegisterBinding", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/logout")
    public String handleLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
