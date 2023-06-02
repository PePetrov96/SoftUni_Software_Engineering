package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.model.Category;
import com.example.jsonprocessing.model.DTOs.CategoryDTO;
import com.example.jsonprocessing.model.DTOs.CategoryProductJsonDTO;
import com.example.jsonprocessing.repositories.CategoryRepository;
import com.example.jsonprocessing.services.CategoryService;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    @Transactional
    public void importCategoriesFromJson() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/categories.json"))) {
            CategoryDTO[] categoryDTOS = this.gson.fromJson(reader, CategoryDTO[].class);

            for (CategoryDTO categoryDto : categoryDTOS) {
                Category category = modelMapper.map(categoryDto, Category.class);
                this.categoryRepository.save(category);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void exportCategoriesByProductCount() {
        List<CategoryProductJsonDTO> categories = this.categoryRepository
                .findAll()
                .stream()
                .map(this::convertToCategoryProductJsonDto)
                .sorted(Comparator.comparingLong(CategoryProductJsonDTO::getProductsCount).reversed())
                .collect(Collectors.toList());

        String filePath = "src/main/resources/exports/categoriesByProductCount.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(categories, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CategoryProductJsonDTO convertToCategoryProductJsonDto(Category category) {
        long productsCount = category.getProducts().size();

        BigDecimal averagePrice = category.getProducts().stream()
                .map(product -> BigDecimal.valueOf(product.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(productsCount), 2, RoundingMode.HALF_UP);

        BigDecimal totalRevenue = category.getProducts().stream()
                .map(product -> BigDecimal.valueOf(product.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CategoryProductJsonDTO(
                category.getName(),
                productsCount,
                averagePrice,
                totalRevenue);
    }
}
