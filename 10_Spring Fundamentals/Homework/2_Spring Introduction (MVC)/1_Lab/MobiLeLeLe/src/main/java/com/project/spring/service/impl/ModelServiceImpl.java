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
    public boolean isInitialized() {
        return this.modelRepository.count() > 0;
    }

    @Override
    public void importModels() {
        if (isInitialized()) {return;}

        ModelDTO[] modelDTOs = this.gson.fromJson(readModelFileContent(), ModelDTO[].class);

        for (ModelDTO modelDTO : modelDTOs) {
            boolean isValid = this.validator.isValid(modelDTO);
            Optional<Brand> brand = this.brandRepository.findBrandByName(modelDTO.getBrand());

            if (!isValid || brand.isEmpty()) { // if the model is invalid
                System.out.println(message(1, modelDTO.getName()));
                continue;
            }

            if (this.modelRepository.findModelByName(modelDTO.getName()).isPresent()) { // if the model already exists
                System.out.println(message(2, modelDTO.getName()));
                continue;
            }



            try {
                this.modelRepository.saveAndFlush(mapModel(modelDTO, brand.get()));
                System.out.println(message(3, modelDTO.getName()));
            } catch (Exception e) {
                System.out.println(message(4, e.getLocalizedMessage()));
            }
        }
    }

    private Model mapModel(ModelDTO modelDTO, Brand brand) {
        Model model = this.mapper.map(modelDTO, Model.class);
        model.setCreated(LocalDateTime.now());
        model.setModified(LocalDateTime.now());
        model.setBrand(brand);

        return model;
    }

    private String message(int code, String text) {
        return switch (code) {
            case 1 -> String.format("Model %s is invalid", text);
            case 2 -> String.format("Model %s exists!", text);
            case 3 -> String.format("Model %s has been added", text);
            case 4 -> String.format("Something went wrong! - " + text);
            default -> null;
        };
    }
}
