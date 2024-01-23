package com.project.spring.service.impl;

import com.google.gson.Gson;
import com.project.spring.models.dto.BrandDTO;
import com.project.spring.models.dto.ModelDTO;
import com.project.spring.models.entity.Brand;
import com.project.spring.models.entity.Model;
import com.project.spring.repository.BrandRepository;
import com.project.spring.repository.ModelRepository;
import com.project.spring.service.ModelService;
import com.project.spring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ValidationUtil validator, ModelMapper mapper, Gson gson) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.validator = validator;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public String readModelFileContent() {
        try {
            return Files.readString(Path.of("src/main/resources/files/models.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void importModels() {
        ModelDTO[] modelDTOs = this.gson.fromJson(readModelFileContent(), ModelDTO[].class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (ModelDTO modelDTO : modelDTOs) {
            boolean isValid = this.validator.isValid(modelDTO);
            Optional<Brand> brand = this.brandRepository.findBrandByName(modelDTO.getBrand());

            if (!isValid || brand.isEmpty()) { // if the model is invalid
                System.out.printf("Model %s is invalid\n", modelDTO.getName());
                continue;
            }

            if (this.modelRepository.findModelByName(modelDTO.getName()).isPresent()) { // if the model already exists
                System.out.printf("Model %s exists!\n", modelDTO.getName());
                continue;
            }

            Model model = this.mapper.map(modelDTO, Model.class);
            model.setCreated(LocalDateTime.now());
            model.setModified(LocalDateTime.now());
            model.setBrand(brand.get());

            try {
                this.modelRepository.saveAndFlush(model);
                System.out.printf("Model %s has been added\n", model.getName());
            } catch (Exception e) {
                System.out.println("Something went wrong! - " + e.getLocalizedMessage());
            }
        }
    }
}
