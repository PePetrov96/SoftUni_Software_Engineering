package com.example.project.services.Impl;

import com.example.project.DTOs.ExportDTOs.Cars.CarExportDTO;
import com.example.project.DTOs.ExportDTOs.Cars.CarWithPartsExportDTO;
import com.example.project.DTOs.ExportDTOs.Cars.Wrappers.CarExportWrapper;
import com.example.project.DTOs.ExportDTOs.Cars.Wrappers.CarWithPartsExportWrapper;
import com.example.project.DTOs.ExportDTOs.Parts.PartExportDTO;
import com.example.project.DTOs.ExportDTOs.Parts.Wrappers.PartExportWrapper;
import com.example.project.model.Car;
import com.example.project.repositories.CarRepository;
import com.example.project.services.CarService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public void exportToyotaCars() {
        List<Car> carList = this.carRepository
                .findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/export/task_2.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CarExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CarExportWrapper exportWrapper = new CarExportWrapper(
                    carList.stream().map(car -> new CarExportDTO(
                            car.getId(),
                            car.getMake(),
                            car.getModel(),
                            car.getTravelledDistance()))
                            .toList());

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void exportCartsWithParts() {
        List<Car> carList = this.carRepository.findAll();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/export/task_4.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CarWithPartsExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CarWithPartsExportWrapper exportWrapper = new CarWithPartsExportWrapper(
                    carList.stream().map(car -> new CarWithPartsExportDTO(
                            car.getMake(),
                            car.getModel(),
                            car.getTravelledDistance(),
                            car.getParts()
                    )).toList());

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
