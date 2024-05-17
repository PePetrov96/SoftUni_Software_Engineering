package com.resellerapp.controller;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegisterDTO;
import com.resellerapp.model.entity.User;
import com.resellerapp.service.UserService;
import com.resellerapp.vallidation.InvalidCredentialsException;
import com.resellerapp.vallidation.InvalidRegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/user/login")
    public String showLoginForm(Model model) {
        model.addAttribute("userLoginDTO", new UserLoginDTO());
        return "login";
    }

    @GetMapping("user/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/user/login")
    public String loginUser(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult,
                            HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            User user = userService.loginUser(userLoginDTO.getUsername(), userLoginDTO.getPassword());
            session.setAttribute("user", user);
            return "redirect:/home";
        } catch (InvalidCredentialsException e) {
            bindingResult.rejectValue("username", "error.userLoginDTO", e.getMessage());
            return "login";
        }
    }

    @PostMapping("/user/register")
    public String registerUser(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.registerUser(userRegisterDTO);
            return "redirect:/user/login";
        } catch (InvalidRegisterException e) {
            bindingResult.rejectValue("username", "error.userRegisterDTO", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/user/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
