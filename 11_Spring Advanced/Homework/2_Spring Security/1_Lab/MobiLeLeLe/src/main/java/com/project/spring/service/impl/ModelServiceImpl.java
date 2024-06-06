package com.project.spring.service.impl;

import com.google.gson.Gson;
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
import java.util.List;
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
    public boolean hasInitialized() {
        return this.modelRepository.count() > 0;
    }

    @Override
    public List<Model> listAll() {
        return this.modelRepository.findAll();
    }

    @Override
    public void importModels() {
        ModelDTO[] modelDTOs = this.gson.fromJson(readModelFileContent(), ModelDTO[].class);

        for (ModelDTO modelDTO : modelDTOs) {
            if (!validator.isValid(modelDTO)) {
                throw new IllegalArgumentException("Invalid model: " + modelDTO.getName());
            }

            Brand brand = this.brandRepository
                    .findBrandByName(modelDTO.getBrand())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid brand name: " + modelDTO.getBrand()));

            if (this.modelRepository.findModelByName(modelDTO.getName()).isPresent()) {
                throw new IllegalArgumentException("Model " + modelDTO.getName() + " already exists!");
            }

            Model model = mapModel(modelDTO, brand);
            this.modelRepository.saveAndFlush(model);
        }
    }

    private Model mapModel(ModelDTO modelDTO, Brand brand) {
        Model model = this.mapper.map(modelDTO, Model.class);
        model.setCreated(LocalDateTime.now());
        model.setModified(LocalDateTime.now());
        model.setBrand(brand);

        return model;
    }
}
