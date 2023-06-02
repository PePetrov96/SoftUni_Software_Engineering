package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.model.DTOs.*;
import com.example.jsonprocessing.model.Product;
import com.example.jsonprocessing.model.User;
import com.example.jsonprocessing.repositories.UserRepository;
import com.example.jsonprocessing.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
    @Override
    @Transactional
    public void importUsersFromJson() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/users.json"))) {
            UserDTO[] userDTOS = this.gson.fromJson(reader, UserDTO[].class);

            for (UserDTO userDTO : userDTOS) {
                User user = this.modelMapper.map(userDTO, User.class);
                this.userRepository.save(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    @Transactional(readOnly = true)
    public void exportUsersWithSoldProductsToJSON() {
        List<User> users = this.userRepository.findAllBySoldProductsIsNotEmptyOrderByLastNameAscFirstNameAsc()
                .stream()
                .filter(user -> user.getSoldProducts().stream().anyMatch(product -> product.getBuyer() != null))
                .toList();

        List<UserJsonDTO> userJsonDTOS = users.stream()
                .map(this::convertToUserJsonDto)
                .collect(Collectors.toList());

        String filePath = "src/main/resources/exports/usersWithSoldProducts.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(userJsonDTOS, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private UserJsonDTO convertToUserJsonDto(User user) {
        List<ProductWithBuyerJsonDTO> productJsonDtos = user.getSoldProducts().stream()
                .filter(product -> product.getBuyer() != null)
                .map(this::convertToProductJsonDto)
                .collect(Collectors.toList());

        return new UserJsonDTO(user.getFirstName(), user.getLastName(), productJsonDtos);
    }

    private ProductWithBuyerJsonDTO convertToProductJsonDto(Product product) {
        BigDecimal price = BigDecimal.valueOf(product.getPrice()).setScale(2, RoundingMode.DOWN);
        return new ProductWithBuyerJsonDTO(product.getName(), price, product.getBuyer().getFirstName(), product.getBuyer().getLastName());
    }
    @Override
    @Transactional(readOnly = true)
    public void exportUsersByProductsSold() {
    }
}