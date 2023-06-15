package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityCreateDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.Messages.*;
import static softuni.exam.constants.Paths.CITIES_PATH;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtils validator;
    private final ModelMapper mapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository,
                           Gson gson, ValidationUtils validator, ModelMapper mapper) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder out = new StringBuilder();

        CityCreateDTO[] cityDTOs = this.gson.fromJson(readCitiesFileContent(), CityCreateDTO[].class);

        for (CityCreateDTO cityDTO : cityDTOs) {
            boolean isValid = this.validator.isValid(cityDTO);

            if (cityExists(cityDTO)) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(CITY_IMPORTED,
                        cityDTO.getCityName(),
                        cityDTO.getPopulation()));

                City city = this.mapper.map(cityDTO, City.class);
                Country country = this.countryRepository.getById(cityDTO.getCountry());

                city.setCountry(country);

                this.cityRepository.saveAndFlush(city);
            } else {
                out.append(INVALID_CITY);
            }

            out.append(System.lineSeparator());
        }

        return out.toString().trim();
    }

    private boolean cityExists(CityCreateDTO cityDTO) {
        return this.cityRepository
                .findCityByCityName(cityDTO.getCityName())
                .isPresent();
    }
}
