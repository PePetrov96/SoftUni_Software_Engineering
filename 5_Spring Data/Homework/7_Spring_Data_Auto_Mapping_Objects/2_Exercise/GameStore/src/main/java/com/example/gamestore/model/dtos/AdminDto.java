package com.example.gamestore.model.dtos;

public class AdminDto extends BaseUserDto{
    private static final boolean IS_ADMIN = true;
    public AdminDto(String email, String password, String fullName, boolean administrator) {
        super(email, password, fullName, administrator);
    }
}