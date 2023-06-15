package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.exam.models.dto.ForecastCreateDTO;
import softuni.exam.models.dto.ForecastWrapper;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import static softuni.exam.constants.Messages.*;
import static softuni.exam.constants.Paths.FORECASTS_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;


    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository,
                               CityRepository cityRepository, ModelMapper mapper,
                               ValidationUtils validator) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_PATH));
    }

    @Override
    @Transactional
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(FORECASTS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(ForecastWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ForecastWrapper forecastWrapper = (ForecastWrapper) unmarshaller.unmarshal(reader);


            for (ForecastCreateDTO forecastDTO : forecastWrapper.getForecasts()) {
                boolean isValid = this.validator.isValid(forecastDTO);

                City city = this.cityRepository.findById(forecastDTO.getCity()).orElse(null);

                if (city == null) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(FORECAST_IMPORTED,
                            forecastDTO.getDayOfWeek(),
                            forecastDTO.getMaxTemperature()));

                    LocalTime sunrise = LocalTime.parse(forecastDTO.getSunrise(), DateTimeFormatter.ofPattern("HH:mm:ss"));
                    LocalTime sunset = LocalTime.parse(forecastDTO.getSunset(), DateTimeFormatter.ofPattern("HH:mm:ss"));

                    Forecast forecast = new Forecast(
                            forecastDTO.getDayOfWeek(),
                            forecastDTO.getMaxTemperature(),
                            forecastDTO.getMinTemperature(),
                            sunrise,
                            sunset,
                            city);

                    this.forecastRepository.saveAndFlush(forecast);
                } else {
                    out.append(INVALID_FORECAST);
                }

                out.append(System.lineSeparator());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString().trim();
    }

    @Override
    public String exportForecasts() {
        StringBuilder out = new StringBuilder();

        Set<Forecast> forecasts = this.forecastRepository
                .findAllByDayOfWeekIsAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000);

        for (Forecast forecast : forecasts) {

            out.append(String.format(FORECAST_EXPORT,
                            forecast.getCity().getCityName(),
                            forecast.getMinTemperature(),
                            forecast.getMaxTemperature(),
                            forecast.getSunrise(),
                            forecast.getSunset()))
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
