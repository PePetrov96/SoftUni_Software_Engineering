package com.project.spring.service.impl;

import com.google.gson.Gson;
import com.project.spring.models.dto.BrandDTO;
import com.project.spring.models.entity.Brand;
import com.project.spring.repository.BrandRepository;
import com.project.spring.service.BrandService;
import com.project.spring.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ValidationUtil validator, ModelMapper mapper, Gson gson) {
        this.brandRepository = brandRepository;
        this.validator = validator;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public String readBrandFileContent() {
        try {
            return Files.readString(Path.of("src/main/resources/files/brands.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isInitializes() {
        return this.brandRepository.count() > 0;
    }


    @Override
    public void importBrands() {
        if (isInitializes()) {return;}

        BrandDTO[] brandDTOs = this.gson.fromJson(readBrandFileContent(), BrandDTO[].class);

        for (BrandDTO brandDTO : brandDTOs) {
            boolean isValid = this.validator.isValid(brandDTO);

            if (!isValid) { //if the brand is invalid
                this.validator
                        .violations(brandDTO)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }

            if (this.brandRepository.findBrandByName(brandDTO.getName()).isPresent()) { // if the brand already exists
                System.out.println(message(1, brandDTO.getName()));
                continue;
            }

            try {
                this.brandRepository.saveAndFlush(mapBrand(brandDTO));

                System.out.println(message(2, brandDTO.getName()));

            } catch (Exception e) {
                System.out.println(message(3, e.getLocalizedMessage()));
            }
        }
    }

    @Override
    public List<Brand> postBrands() {
        return this.brandRepository.findAll();
    }

    private Brand mapBrand(BrandDTO brandDTO) {
        Brand brand = this.mapper.map(brandDTO, Brand.class);
        brand.setCreated(LocalDateTime.now());
        brand.setModified(LocalDateTime.now());

        return brand;
    }

    private String message(int code, String text) {
        return switch (code) {
            case 1 -> String.format("Brand %s exists!", text);
            case 2 -> String.format("Brand %s has been added", text);
            case 3 -> String.format("Something went wrong! - " + text);
            default -> null;
        };
    }
}
