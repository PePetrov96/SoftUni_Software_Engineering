package com.project.spring.web;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.User;
import com.project.spring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    private final UserService userService;
    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(HttpSession session, UserDTO userDTO) {
        User user = this.userService.authenticate(userDTO);
        session.setAttribute("user", user);
        return "redirect:/";
    }
}
