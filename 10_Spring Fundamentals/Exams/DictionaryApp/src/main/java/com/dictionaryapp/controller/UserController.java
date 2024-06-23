package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.UserLoginBindingModel;
import com.dictionaryapp.model.dto.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.validation.exceptions.EmailAlreadyExistsException;
import com.dictionaryapp.validation.exceptions.UsernameAlreadyExistsException;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    private String displayLoginPage(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid UserLoginBindingModel userLoginBindingModel,
                            BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            User user = this.userService.loginUser(userLoginBindingModel);
            session.setAttribute("user", user);
            return "redirect:/home";
        } catch (Exception e) {
            bindingResult.rejectValue("username", "error.userLoginBindingModel", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/register")
    private String displayRegisterPage(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            this.userService.registerUser(userRegisterBindingModel);
            return "redirect:/user/login";
        } catch (UsernameAlreadyExistsException e) {
            bindingResult.rejectValue("username", "error.userRegisterBindingModel", e.getMessage());
            return "register";
        } catch (EmailAlreadyExistsException e) {
            bindingResult.rejectValue("email", "error.userRegisterBindingModel", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
