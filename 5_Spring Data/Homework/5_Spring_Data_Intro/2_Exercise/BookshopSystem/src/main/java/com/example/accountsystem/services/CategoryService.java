package com.example.accountsystem.services;

import com.example.accountsystem.model.Category;

public interface CategoryService {
    void registerCategory(Category category);
    Category getRandomCategory();
}