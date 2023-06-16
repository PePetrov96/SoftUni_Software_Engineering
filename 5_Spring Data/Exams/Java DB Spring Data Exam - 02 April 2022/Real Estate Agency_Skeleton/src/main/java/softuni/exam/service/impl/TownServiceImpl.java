package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownCreateDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.Messages.IMPORT_TOWN;
import static softuni.exam.constants.Messages.INVALID_TOWN;
import static softuni.exam.constants.Paths.TOWNS_PATH;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtils validator;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper, Gson gson, ValidationUtils validator) {
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWNS_PATH));
    }

    @Override
    public String importTowns() throws IOException {
        StringBuilder out = new StringBuilder();

        TownCreateDTO[] townDTOs = this.gson.fromJson(readTownsFileContent(), TownCreateDTO[].class);

        for (TownCreateDTO townDTO : townDTOs) {
            boolean isValid = this.validator.isValid(townDTO);

            if (this.townRepository.findTownByTownName(townDTO.getTownName()).isPresent()) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(IMPORT_TOWN, townDTO.getTownName(), townDTO.getPopulation()));

                this.townRepository.saveAndFlush(mapper.map(townDTO, Town.class));
            } else {
                out.append(String.format(INVALID_TOWN));
            }

        }

        return out.toString().trim();
    }
}
