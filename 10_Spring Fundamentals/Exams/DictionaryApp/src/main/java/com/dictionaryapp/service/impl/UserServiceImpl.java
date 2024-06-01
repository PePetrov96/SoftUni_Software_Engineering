package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.UserLoginBindingModel;
import com.dictionaryapp.model.dto.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.validation.EmailAlreadyExistsException;
import com.dictionaryapp.validation.IncorrectUsernameOrPasswordException;
import com.dictionaryapp.validation.UsernameAlreadyExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        if (this.userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException();
        }

        if (this.userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        String password = this.passwordEncoder.encode(userRegisterBindingModel.getPassword());

        User user = this.modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(password);
        this.userRepository.save(user);
    }

    @Override
    public User loginUser(UserLoginBindingModel userLoginBindingModel) {
        Optional<User> user = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        //Check if username is not found or password is incorrect
        if (user.isEmpty() ||
                !passwordEncoder.matches(userLoginBindingModel.getPassword(), user.get().getPassword())) {
            throw new IncorrectUsernameOrPasswordException();
        }

        return user.get();
    }
}
