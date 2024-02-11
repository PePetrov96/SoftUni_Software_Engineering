package com.project.spring.web;

import com.project.spring.models.dto.UserDTO;
import com.project.spring.models.entity.User;
import com.project.spring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER logic below

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDTO") UserDTO userDTO, Model model) {
        List<String> errors = this.userService.registerUser(userDTO);

        if (errors == null) {
            return "redirect:/";
        } else {
            for (String error : errors) {
                model.addAttribute(error, true);
            }
            model.addAttribute("userDTO", userDTO);
            return "auth-register";
        }
    }

    // LOG-IN logic below

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String loginUser(HttpSession session, UserDTO userDTO, Model model) {

        User user = this.userService.authenticate(userDTO);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("error", true);
            return "auth-login";
        }
    }

    // LOG-OUT logic below

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
