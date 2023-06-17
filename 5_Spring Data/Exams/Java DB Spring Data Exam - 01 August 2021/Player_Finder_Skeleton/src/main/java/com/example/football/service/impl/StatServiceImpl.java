package com.example.football.service.impl;

import com.example.football.models.dto.stat.StatCreateDTO;
import com.example.football.models.dto.wrappers.StatsWrapper;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.constants.Messages.INVALID_STAT;
import static com.example.football.constants.Messages.STAT_IMPORTED;
import static com.example.football.constants.Paths.STATS_PATH;

@Service
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;

    @Autowired
    public StatServiceImpl(StatRepository statRepository, ModelMapper mapper, ValidationUtils validator) {
        this.statRepository = statRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent()  {
        try {
            return Files.readString(Path.of(STATS_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String importStats() {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(STATS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(StatsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StatsWrapper statsWrapper = (StatsWrapper) unmarshaller.unmarshal(reader);

            for (StatCreateDTO statDTO : statsWrapper.getStats()) {
                boolean isValid = this.validator.isValid(statDTO);

                if (isValid) {
                    out.append(String.format(STAT_IMPORTED,
                            statDTO.getPassing(), statDTO.getShooting(), statDTO.getEndurance()));

                    this.statRepository.save(this.mapper.map(statDTO, Stat.class));
                } else {
                    out.append(String.format(INVALID_STAT));
                }
            }

            this.statRepository.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toString().trim();
    }
}
