package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.CountryCreateDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.Paths.COUNTRIES_PATH;
import static softuni.exam.constants.Messages.*;


@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtils validator;
    private final ModelMapper mapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtils validator, ModelMapper mapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_PATH));
    }

    @Override
    @Transactional
    public String importCountries() throws IOException {
        final StringBuilder out = new StringBuilder();

        CountryCreateDTO[] countryDTOs = this.gson.fromJson(readCountriesFromFile(), CountryCreateDTO[].class);

        for (CountryCreateDTO countryDTO : countryDTOs) {
            boolean isValid = this.validator.isValid(countryDTO);

            if (countryExists(countryDTO)) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(COUNTRY_IMPORTED,
                        countryDTO.getCountryName(),
                        countryDTO.getCurrency()));

                saveCountry(countryDTO);
            } else {
                out.append(INVALID_COUNTRY);
            }

            out.append(System.lineSeparator());
        }

        return out.toString().trim();
    }

    private void saveCountry(CountryCreateDTO countryDTO) {
        this.countryRepository
                .saveAndFlush(mapper.map(countryDTO, Country.class));
    }

    private boolean countryExists(CountryCreateDTO countryDTO) {
        return this.countryRepository
                .findCountryByCountryName(countryDTO.getCountryName())
                .isPresent();
    }
}
