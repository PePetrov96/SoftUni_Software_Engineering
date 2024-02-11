package com.project.spring.web;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserRegisterController {
    private final UserService userService;
    @Autowired
    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO) {
        this.userService.registerUser(userDTO);
        return "redirect:/";
    }
}
