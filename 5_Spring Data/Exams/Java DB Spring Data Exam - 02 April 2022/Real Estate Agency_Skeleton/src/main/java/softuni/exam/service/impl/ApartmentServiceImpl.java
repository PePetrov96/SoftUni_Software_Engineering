package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentCreateDTO;
import softuni.exam.models.dto.wrappers.ApartmentsWrapper;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.constants.Messages.IMPORT_APARTMENT;
import static softuni.exam.constants.Messages.INVALID_APARTMENT;
import static softuni.exam.constants.Paths.APARTMENTS_PATH;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final TownRepository townRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;

    @Autowired
    public ApartmentServiceImpl(TownRepository townRepository, ApartmentRepository apartmentRepository,
                                ModelMapper mapper, ValidationUtils validator) {
        this.townRepository = townRepository;
        this.apartmentRepository = apartmentRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENTS_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(APARTMENTS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(ApartmentsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ApartmentsWrapper apartmentsWrapper = (ApartmentsWrapper) unmarshaller.unmarshal(reader);

            for (ApartmentCreateDTO apartmentDTO : apartmentsWrapper.getApartments()) {
                boolean isValid = this.validator.isValid(apartmentDTO);

                if (this.apartmentRepository.findApartmentByTown_TownNameAndArea(apartmentDTO.getTown(), apartmentDTO.getArea()).isPresent()) {
                    isValid = false;
                }

                Optional<Town> town = this.townRepository.findTownByTownName(apartmentDTO.getTown());

                if (town.isEmpty()) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(IMPORT_APARTMENT, apartmentDTO.getApartmentType(), apartmentDTO.getArea()));

                    Apartment apartment = this.mapper.map(apartmentDTO, Apartment.class);
                    apartment.setTown(town.get());

                    this.apartmentRepository.saveAndFlush(apartment);

                } else {
                    out.append(String.format(INVALID_APARTMENT));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



        return out.toString().trim();
    }
}
