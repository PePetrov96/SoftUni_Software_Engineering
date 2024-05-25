package com.plannerapp.service.impl;

import com.plannerapp.model.dto.UserLoginBindingModel;
import com.plannerapp.model.dto.UserRegisterBindingModel;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import com.plannerapp.vallidation.UserAlreadyExistsException;
import com.plannerapp.vallidation.UsernameNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userRegisterBindingModel.getPassword());

        User user = new User();
        this.modelMapper.map(userRegisterBindingModel, user);
        user.setPassword(encodedPassword);

        this.userRepository.save(user);
    }

    @Override
    public User loginUser(UserLoginBindingModel userLoginBindingModel) {
        Optional<User> user = userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (user.isEmpty()) {
            throw new UsernameNotFoundException();
        }

        boolean passwordMatches = bCryptPasswordEncoder.matches(userLoginBindingModel.getPassword(), user.get().getPassword());

        if (!passwordMatches) {
            throw new UsernameNotFoundException();
        }

        return user.orElse(null);
    }
}
