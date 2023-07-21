package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartCreateDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartsServiceImpl implements PartsService {
    public static final String PARTS_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partsRepository;
    private final ValidationUtils validator;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository, ModelMapper mapper,
                            Gson gson, ValidationUtils validator) {
        this.partsRepository = partsRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder out = new StringBuilder();

        List<PartCreateDTO> partDTOs = Arrays
                .stream(this.gson.fromJson(readPartsFileContent(), PartCreateDTO[].class))
                .collect(Collectors.toList());

        for (PartCreateDTO partDTO : partDTOs) {

            if (this.partsRepository.findPartByPartName(partDTO.getPartName()).isPresent() ||
                    !this.validator.isValid(partDTO)) {
                out.append(String.format("Invalid part%n"));

                continue;
            }

            this.partsRepository.saveAndFlush(this.mapper.map(partDTO, Part.class));

            String formattedPrice;
            int fractionalPart = (int)((partDTO.getPrice() * 100) % 10);

            if (fractionalPart == 0) {
                formattedPrice = String.format("%.1f", partDTO.getPrice());
            } else {
                formattedPrice = String.format("%.2f", partDTO.getPrice());
            }

            out.append(String.format("Successfully imported part %s - %s%n",
                    partDTO.getPartName(), formattedPrice));
        }

        return out.toString().trim();
    }
}
