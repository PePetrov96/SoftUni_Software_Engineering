package com.example.accountsystem.services;

import com.example.accountsystem.model.Category;

import com.example.accountsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void registerCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category getRandomCategory() {
        List<Category> categories = categoryRepository.findAll();
        int randomIndex = new Random().nextInt(categories.size());
        return categories.get(randomIndex);
    }
}