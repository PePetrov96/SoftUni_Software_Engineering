package com.example.jsonprocessing.services;

public interface UserService {
    void importUsersFromJson();
    void exportUsersWithSoldProductsToJSON();
    void exportUsersByProductsSold();
}
