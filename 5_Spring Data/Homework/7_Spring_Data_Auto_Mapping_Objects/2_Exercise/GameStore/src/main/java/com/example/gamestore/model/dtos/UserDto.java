package com.example.gamestore.model.dtos;

public class UserDto extends BaseUserDto {
    private static final boolean IS_ADMIN = false;
    public UserDto(String email, String password, String fullName) {
        super(email, password, fullName, IS_ADMIN);
    }
}