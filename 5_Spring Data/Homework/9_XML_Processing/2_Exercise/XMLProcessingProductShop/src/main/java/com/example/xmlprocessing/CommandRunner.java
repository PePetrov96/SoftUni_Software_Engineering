package com.example.xmlprocessing;

import com.example.xmlprocessing.services.CategoryService;
import com.example.xmlprocessing.services.ProductService;
import com.example.xmlprocessing.services.SeedService;
import com.example.xmlprocessing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CommandRunner implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final SeedService seedService;

    @Autowired
    public CommandRunner(UserService userService, CategoryService categoryService,
                         ProductService productService, SeedService seedService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();

        Task_1_Products_in_Range();

        Task_2_Successfully_Sold_Products();

        Task_3_Categories_by_Products_Count();

        Task_4_Users_and_Products();
    }
    private void seedDatabase() {
        this.seedService.seedUsers();
        this.seedService.seedCategories();
        this.seedService.seedProducts();
    }

    private void Task_1_Products_in_Range() {
        this.productService.exportProductsInRange(500,1000);
    }

    private void Task_2_Successfully_Sold_Products() {
        this.userService.exportUsersWithSoldProducts();
    }

    private void Task_3_Categories_by_Products_Count() {
        this.categoryService.exportCategoriesByProductsCount();
    }

    private void Task_4_Users_and_Products() {
        this.userService.exportUsersAndProducts();
    }

}