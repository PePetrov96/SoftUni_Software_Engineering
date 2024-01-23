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
import java.time.format.DateTimeFormatter;

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
    public void importBrands() {
        BrandDTO[] brandDTOs = this.gson.fromJson(readBrandFileContent(), BrandDTO[].class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
                System.out.printf("Brand %s exists!\n", brandDTO.getName());
                continue;
            }

            try { //try creating a brand and save it to the DB
                Brand brand = this.mapper.map(brandDTO, Brand.class);
                brand.setCreated(LocalDate.parse(brandDTO.getCreated(), formatter));
                brand.setModified(LocalDate.parse(brandDTO.getCreated(), formatter));

                this.brandRepository.saveAndFlush(brand);

                System.out.printf("Brand %s has been added\n", brandDTO.getName());

            } catch (Exception e) {
                System.out.println("Something went wrong! - " + e.getLocalizedMessage());
            }
        }
    }
}
