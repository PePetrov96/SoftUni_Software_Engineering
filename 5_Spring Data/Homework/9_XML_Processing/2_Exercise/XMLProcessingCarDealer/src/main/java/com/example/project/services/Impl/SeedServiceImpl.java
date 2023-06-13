package com.example.project.services.Impl;

import com.example.project.DTOs.CreateDTOs.CarDTO;
import com.example.project.DTOs.CreateDTOs.CustomerDTO;
import com.example.project.DTOs.CreateDTOs.PartDTO;
import com.example.project.DTOs.CreateDTOs.SupplierDTO;
import com.example.project.DTOs.CreateDTOs.Wrappers.CarWrapper;
import com.example.project.DTOs.CreateDTOs.Wrappers.CustomerWrapper;
import com.example.project.DTOs.CreateDTOs.Wrappers.PartWrapper;
import com.example.project.DTOs.CreateDTOs.Wrappers.SupplierWrapper;
import com.example.project.model.*;
import com.example.project.repositories.*;
import com.example.project.services.SeedService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class SeedServiceImpl implements SeedService {
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final ModelMapper MODDEL_MAPPER;
    private long partsSize;
    private long suppliersSize;
    private long carsSize;
    private long customersSize;

    @Autowired
    public SeedServiceImpl(SupplierRepository supplierRepository, PartRepository partRepository,
                           CarRepository carRepository, CustomerRepository customerRepository,
                           SaleRepository saleRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;

        this.MODDEL_MAPPER = modelMapper;

        this.carsSize = this.carRepository.count();
        this.customersSize = this.customerRepository.count();
    }

    @Override
    @Transactional
    public void seedSuppliers() {
        if (this.supplierRepository.count() > 0) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/import/suppliers.xml"))) {
            JAXBContext context = JAXBContext.newInstance(SupplierWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            SupplierWrapper supplierWrapper = (SupplierWrapper) unmarshaller.unmarshal(reader);

            for (SupplierDTO supplierDTO: supplierWrapper.getSuppliers()) {
                this.supplierRepository.save(MODDEL_MAPPER.map(supplierDTO, Supplier.class));
            }
            this.supplierRepository.flush();
            this.suppliersSize = this.supplierRepository.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void seedParts() {
        if (this.partRepository.count() > 0) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/import/parts.xml"))) {
            JAXBContext context = JAXBContext.newInstance(PartWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            PartWrapper partWrapper = (PartWrapper) unmarshaller.unmarshal(reader);

            for (PartDTO partDTO: partWrapper.getParts()) {
                Part part = MODDEL_MAPPER.map(partDTO, Part.class);
                part.setSupplier(getRandomSupplier());

                this.partRepository.save(part);
            }
            this.partRepository.flush();
            this.partsSize = this.partRepository.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void seedCars() {
        if (this.carRepository.count() > 0) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/import/cars.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CarWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            CarWrapper carWrapper = (CarWrapper) unmarshaller.unmarshal(reader);

            for (CarDTO cardDTO: carWrapper.getCars()) {
                Car car = MODDEL_MAPPER.map(cardDTO, Car.class);

                Random rnd = new Random();
                int n = rnd.nextInt(10, 21);

                for (int i = 1; i <= n; i++) {
                    car.addPart(getRandomPart(car.getParts()));
                }

                this.carRepository.save(car);
            }

            this.carRepository.flush();
            this.carsSize = carRepository.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void seedCustomers() {
        if (this.customerRepository.count() > 0) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/import/customers.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CustomerWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            CustomerWrapper customerWrapper = (CustomerWrapper) unmarshaller.unmarshal(reader);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

            for (CustomerDTO customerDTO:customerWrapper.getCustomers()) {
                LocalDateTime parsedBirthDate = LocalDateTime.parse(customerDTO.getBirthDate(), formatter);

                Customer customer = MODDEL_MAPPER.map(customerDTO, Customer.class);

                customer.setBirthDate(parsedBirthDate);

                this.customerRepository.save(customer);
            }

            this.customerRepository.flush();
            this.customersSize = this.customerRepository.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void seedSales() {
        if (this.saleRepository.count() > 0) {
            return;
        }

        Random rnd = new Random();

        BigDecimal[] discounts = {
                new BigDecimal(0),new BigDecimal(5),
                new BigDecimal(10),new BigDecimal(15),
                new BigDecimal(20),new BigDecimal(30),
                new BigDecimal(40),new BigDecimal(50)};

        for (Car car : this.carRepository.findAll()) { // no condition so I suppose all cars are sold
            Customer customer = getRandomCustomer();
            BigDecimal discount = discounts[rnd.nextInt(8)];

            Sale sale = new Sale(car, customer, discount);

            this.saleRepository.save(sale);
        }

        this.saleRepository.flush();

    }

    private Part getRandomPart(List<Part> parts) {
        Random rnd = new Random();
        long index = rnd.nextLong(this.partsSize) + 1;
        Part part = this.partRepository.findById(index).orElse(null);

        if (parts.contains(part)) { //make sure we add UNIQUE parts
            return getRandomPart(parts);
        }

        return part;
    }

    private Supplier getRandomSupplier() {
        Random rnd = new Random();
        long index = rnd.nextLong(this.suppliersSize) + 1;
        return this.supplierRepository.findById(index).orElse(null);
    }

    private Customer getRandomCustomer() {
        Random rnd = new Random();
        long index = rnd.nextLong(this.customersSize) + 1;
        return this.customerRepository.findById(index).orElse(null);
    }
}
