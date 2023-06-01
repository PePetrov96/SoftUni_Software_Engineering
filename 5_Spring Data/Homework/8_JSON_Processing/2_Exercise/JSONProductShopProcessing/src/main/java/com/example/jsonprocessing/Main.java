package com.example.jsonprocessing;

import com.example.jsonprocessing.services.CategoryService;
import com.example.jsonprocessing.services.ProductService;
import com.example.jsonprocessing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public Main(UserService userService, CategoryService categoryService, ProductService productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        productsInRange();

        successfullySoldProducts();

        categoriesByProductsCount();

//        usersAndProducts(); //not working. Poor SoftUni materials (...none at all for that matter) and lack of information. Got tired of this shit.
    }

    private void usersAndProducts() {
        this.userService.exportUsersByProductsSold();
    }

    private void categoriesByProductsCount() {
        this.categoryService.exportCategoriesByProductCount();
    }

    private void successfullySoldProducts() {
        this.userService.exportUsersWithSoldProductsToJSON();
    }
    private void productsInRange() {
        this.productService
                .exportProductsToJSON(
                        500.00,
                        1000.00,
                        "productsInRange.json");
    }
    private void seedData() {
        seedUsers();
        seedCategories();
        seedProducts();
    }
    private void seedProducts() {
        this.productService.importProductsFromJson();
    }
    private void seedCategories() {
        this.categoryService.importCategoriesFromJson();
    }
    private void seedUsers() {
        this.userService.importUsersFromJson();
    }
}