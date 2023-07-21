package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicCreateDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MechanicsServiceImpl implements MechanicsService {
    public static final String MECHANICS_PATH = "src/main/resources/files/json/mechanics.json";

    private final MechanicsRepository mechanicsRepository;
    private final ValidationUtils validator;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, ModelMapper mapper, Gson gson, ValidationUtils validator) {
        this.mechanicsRepository = mechanicsRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder out = new StringBuilder();

        List <MechanicCreateDTO> mechanicDTOs = Arrays
                .stream(this.gson.fromJson(readMechanicsFromFile(), MechanicCreateDTO[].class))
                .collect(Collectors.toList());

        for (MechanicCreateDTO mechanicDTO : mechanicDTOs) {

            if (this.mechanicsRepository.findMechanicByFirstName(mechanicDTO.getFirstName()).isPresent() ||
                    this.mechanicsRepository.findMechanicByEmail(mechanicDTO.getEmail()).isPresent() ||
            !this.validator.isValid(mechanicDTO)) {
                out.append(String.format("Invalid mechanic%n"));

                continue;
            }
            this.mechanicsRepository.saveAndFlush(this.mapper.map(mechanicDTO, Mechanic.class));

            out.append(String.format("Successfully imported mechanic %s %s%n",
                    mechanicDTO.getFirstName(), mechanicDTO.getLastName()));
        }

        return out.toString().trim();
    }
}
