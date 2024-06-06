package com.project.spring.service.impl;

import com.google.gson.Gson;
import com.project.spring.models.dto.BrandDTO;
import com.project.spring.models.entity.Brand;
import com.project.spring.repository.BrandRepository;
import com.project.spring.service.BrandService;
import com.project.spring.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    public boolean hasInitialized() {
        return this.brandRepository.count() > 0;
    }

    @Override
    public void importBrands() {
        BrandDTO[] brandDTOs = this.gson.fromJson(readBrandFileContent(), BrandDTO[].class);

        for (BrandDTO brandDTO : brandDTOs) {
            if (!this.validator.isValid(brandDTO)) {
                Set<ConstraintViolation<BrandDTO>> violations = this.validator.violations(brandDTO);
                throw new ConstraintViolationException(violations);
            }

            if (this.brandRepository.findBrandByName(brandDTO.getName()).isPresent()) { // if the brand already exists
                throw new IllegalArgumentException("Brand " + brandDTO.getName() + " already exists!");
            }

            this.brandRepository.saveAndFlush(mapBrand(brandDTO));
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
}