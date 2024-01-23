package com.project.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegisterController {
    @GetMapping("/users/register")
    public String login() {
        return "auth-register";
    }
}
