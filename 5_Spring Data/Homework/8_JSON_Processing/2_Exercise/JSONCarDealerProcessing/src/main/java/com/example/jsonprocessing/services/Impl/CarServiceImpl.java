package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.config.GsonBuilderWrapper;
import com.example.jsonprocessing.model.Car;
import com.example.jsonprocessing.model.DTOs.*;
import com.example.jsonprocessing.model.Part;
import com.example.jsonprocessing.repositories.CarRepository;
import com.example.jsonprocessing.repositories.PartRepository;
import com.example.jsonprocessing.services.CarService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private Long partSize;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;

        this.mapper = modelMapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    @Transactional
    public void seedData() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/cars.json"))) {
            this.partSize = (long) this.partRepository.findAll().size();
            CarCreateFromJsonDTO[] carDTOs = this.gson.fromJson(reader, CarCreateFromJsonDTO[].class);

            for (CarCreateFromJsonDTO carDTO:carDTOs) {
                int numParts = ThreadLocalRandom.current().nextInt(3, 6); // random number between 3 and 5

                Car car = this.mapper.map(carDTO, Car.class);

                for (int i = 1; i <= numParts; i++) { //get N (random) number of random parts
                    car.addPart(getRandomPart());
                }

                this.carRepository.save(car);
            }

            this.carRepository.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Part getRandomPart() {
        long index = ThreadLocalRandom.current().nextLong(1, partSize + 1);
        return this.partRepository.findById(index).orElse(null);
    }

    @Override
    public void exportCarsFromMakeToyota() {
        List<Car> cars = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");

        List<CarJsonExportDTO> carJsonDTOs = cars.stream()
                .map(this::convertCarJsonExport1)
                .toList();

        String filePath = "src/main/resources/exports/Task_2_Cars_from_Make_Toyota.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            this.gson.toJson(carJsonDTOs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CarJsonExportDTO convertCarJsonExport1(Car car) {
        return new CarJsonExportDTO(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getTravelledDistance());
    }

    @Override
    @Transactional(readOnly = true)
    public void exportCarsAndParts() {
        List<Car> cars = this.carRepository.findAll();

        List<CarPartWrapperJsonExportDTO> carJsonDTOs = cars.stream()
                .map(this::convertCarJsonExport2)
                .toList();

        String filePath = "src/main/resources/exports/Task_4_Cars_with_Their_List_of_Parts.json";

        List<String> fields = new ArrayList<>(); fields.add("Quantity");
        Gson gsonNew = new GsonBuilderWrapper(fields).createGson();

        try (FileWriter writer = new FileWriter(filePath)) {
            gsonNew.toJson(carJsonDTOs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CarPartWrapperJsonExportDTO convertCarJsonExport2(Car car) {
        CarJsonExportDTO carJsonExportDTO = new CarJsonExportDTO(
                car.getMake(),
                car.getModel(),
                car.getTravelledDistance()
        );

        List<PartJsonExportDTO> partJsonExportDTOs = car.getParts().stream()
                .map(this::convertPartJsonExport)
                .collect(Collectors.toList());

        return new CarPartWrapperJsonExportDTO(carJsonExportDTO, partJsonExportDTOs);
    }

    private PartJsonExportDTO convertPartJsonExport(Part part) {
        return new PartJsonExportDTO(
                part.getName(),
                part.getPrice());
    }

    @Override
    @Transactional(readOnly = true)
    public void exportSalesWithDiscount() {
        //
        List<Car> cars = this.carRepository.findAll();

        List<CarJsonExportDTO> carExportDTOs = cars.stream()
                .map(this::convertCarJsonExport3)
                .toList();

        String filePath = "src/main/resources/exports/Task_6_Sales_with_Applied_Discount.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            this.gson.toJson(carExportDTOs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CarJsonExportDTO convertCarJsonExport3(Car car) {
        return new CarJsonExportDTO(
                car.getMake(),
                car.getModel(),
                car.getTravelledDistance(),
                car.getSale());
    }
}