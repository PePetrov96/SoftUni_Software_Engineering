package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarCreateDTO;
import softuni.exam.models.dto.wrappers.CarWrapper;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;
    private final ModelMapper mapper;
    private final softuni.exam.util.ValidationUtils validator;
    private final XmlParser xmlParser;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper mapper, ValidationUtils validator, XmlParser xmlParser) {
        this.carsRepository = carsRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.carsRepository.count() >= 1;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        List<CarCreateDTO> carDTOs = this.xmlParser
                .fromFile(Path.of(CARS_FILE_PATH).toFile(), CarWrapper.class)
                .getCars();

        for (CarCreateDTO carDTO : carDTOs) {

            if (this.carsRepository.findCarByPlateNumber(carDTO.getPlateNumber()).isPresent() ||
                    !this.validator.isValid(carDTO)) {
                out.append(String.format("Invalid car%n"));

                continue;
            }

            this.carsRepository.saveAndFlush(this.mapper.map(carDTO, Car.class));

            out.append(String.format("Successfully imported car %s - %s%n"
                    , carDTO.getCarMake(), carDTO.getCarModel()));
        }


        return out.toString().trim();
    }
}
