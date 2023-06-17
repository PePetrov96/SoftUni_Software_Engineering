package com.example.football.service.impl;

import com.example.football.models.dto.town.TownCreateDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static com.example.football.constants.Messages.INVALID_TOWN;
import static com.example.football.constants.Messages.TOWN_IMPORTED;
import static com.example.football.constants.Paths.TOWNS_PATH;


@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper, ValidationUtils validator, Gson gson) {
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() {
        try {
            return Files.readString(Path.of(TOWNS_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String importTowns() {
        StringBuilder out = new StringBuilder();

        TownCreateDTO[] townDTOs = this.gson.fromJson(readTownsFileContent(), TownCreateDTO[].class);

        for (TownCreateDTO townDTO : townDTOs) {
            boolean isValid = this.validator.isValid(townDTO);

            Optional<Town> town = this.townRepository.findTownByName(townDTO.getName());

            if (town.isPresent()) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(TOWN_IMPORTED, townDTO.getName(), townDTO.getPopulation()));

                this.townRepository.saveAndFlush(this.mapper.map(townDTO, Town.class));
            } else {
                out.append(String.format(INVALID_TOWN));
            }
        }

        return out.toString().trim();
    }
}
