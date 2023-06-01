package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.model.Category;
import com.example.jsonprocessing.model.DTOs.CategoryDto;
import com.example.jsonprocessing.model.DTOs.ProductDto;
import com.example.jsonprocessing.model.DTOs.ProductJsonDto;
import com.example.jsonprocessing.model.DTOs.UserDto;
import com.example.jsonprocessing.model.Product;
import com.example.jsonprocessing.model.User;
import com.example.jsonprocessing.repositories.CategoryRepository;
import com.example.jsonprocessing.repositories.ProductRepository;
import com.example.jsonprocessing.repositories.UserRepository;
import com.example.jsonprocessing.services.ProductService;
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
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public ProductServiceImpl(UserRepository userRepository, ProductRepository productRepository,
                              CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    @Transactional
    public void importProductsFromJson() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/products.json"))) {
            ProductDto[] productDtos = this.gson.fromJson(reader, ProductDto[].class);

            int userCount = this.userRepository.countAll();
            int categoryCount = this.categoryRepository.countAll();

            for (ProductDto productDto : productDtos) {
                User seller = getRandomUser(userCount);
                User buyer = getRandomUser(userCount);
                Category category = getRandomCategory(categoryCount);

                // Set the buyer to null for some products
                if (ThreadLocalRandom.current().nextBoolean()) {
                    buyer = null;
                }

                Product product = this.modelMapper.map(productDto, Product.class);
                product.setSeller(Objects.requireNonNull(seller));

                if (buyer != null) {
                    product.setBuyer(buyer);
                    buyer.buyProduct(product);
                }

                product.addCategory(category);

                seller.sellProduct(product);

                this.productRepository.save(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User getRandomUser(int userCount) {
        if (userCount == 0) {
            return null; // No users available
        }
        int index = ThreadLocalRandom.current().nextInt(userCount);
        return this.userRepository.findAll().get(index);
    }

    private Category getRandomCategory(int categoryCount) {
        if (categoryCount == 0) {
            return null; // No categories available
        }
        int index = ThreadLocalRandom.current().nextInt(categoryCount);
        return this.categoryRepository.findAll().get(index);
    }

    @Override
    @Transactional(readOnly = true)
    public void exportProductsToJSON(double minPrice, double maxPrice, String fileName) {
        List<Product> products = getProductsInRangeAndNoBuyer(minPrice, maxPrice);

        List<ProductJsonDto> productJsonDtos = products.stream()
                .map(this::convertToProductJsonDto)
                .collect(Collectors.toList());

        String filePath = "src/main/resources/exports/" + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(productJsonDtos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public List<Product> getProductsInRangeAndNoBuyer(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(minPrice, maxPrice);
    }

    private ProductJsonDto convertToProductJsonDto(Product product) {
        BigDecimal price = BigDecimal.valueOf(product.getPrice()).setScale(2, RoundingMode.DOWN);
        String sellerName = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();

        return new ProductJsonDto(product.getName(), price, sellerName);
    }
}