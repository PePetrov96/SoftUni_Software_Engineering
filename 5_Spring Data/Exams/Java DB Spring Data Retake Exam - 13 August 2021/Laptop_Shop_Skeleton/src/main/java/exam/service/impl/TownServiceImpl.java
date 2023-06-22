package exam.service.impl;

import exam.model.Town;
import exam.model.dtos.TownCreateDTO;
import exam.model.dtos.TownCreateWrapper;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static exam.constants.Messages.INVALID_TOWN;
import static exam.constants.Messages.TOWN_IMPORTED;
import static exam.constants.Paths.TOWNS_PATH;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper mapper;

    private final ValidationUtil validator;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper mapper, ValidationUtil validator) {
        this.townRepository = townRepository;
        this.mapper = mapper;
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
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(TOWNS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(TownCreateWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            TownCreateWrapper townCreateWrapper = (TownCreateWrapper) unmarshaller.unmarshal(reader);

            for (TownCreateDTO townDTO : townCreateWrapper.getTowns()) {
                boolean isValid = this.validator.isValid(townDTO);

                if (this.townRepository.findTownByName(townDTO.getName()).isPresent()) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(TOWN_IMPORTED, townDTO.getName()));

                    this.townRepository
                            .saveAndFlush(mapper.map(townDTO, Town.class));
                } else {
                    out.append(String.format(INVALID_TOWN));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toString().trim();
    }
}
