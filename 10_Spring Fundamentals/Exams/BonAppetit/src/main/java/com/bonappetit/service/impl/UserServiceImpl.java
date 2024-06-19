package com.bonappetit.service.impl;

import com.bonappetit.model.dto.UserLoginDTO;
import com.bonappetit.model.dto.UserRegisterDTO;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

import static com.bonappetit.util.Constants.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String showLoginPage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return "redirect:" + HOME_URL;
        }
        model.addAttribute("userLoginDTO", new UserLoginDTO());
        return LOGIN_HTML;
    }

    @Override
    public String handleLoginUser(UserLoginDTO userLoginDTO, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return LOGIN_HTML;
        }

        User user = modelMapper.map(userLoginDTO, User.class);
        httpSession.setAttribute("user", user);
        return "redirect:" + HOME_URL;
    }

    @Override
    public String showRegisterPage(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return "redirect:" + HOME_URL;
        }

        model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        return REGISTER_HTML;
    }

    @Override
    public String handleRegisterUser(UserRegisterDTO userRegisterDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return REGISTER_HTML;
        }

        saveUserToDataBase(userRegisterDTO);
        return "redirect:" + LOGIN_URL;
    }

    @Override
    public String handleLogoutUser(HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            httpSession.invalidate();
        }

        return "redirect:" + INDEX_URL;
    }

    private void saveUserToDataBase(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        this.userRepository.save(user);
    }
}
