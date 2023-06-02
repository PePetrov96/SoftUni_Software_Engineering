package com.example.jsonprocessing;

import com.example.jsonprocessing.services.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public Main(CarService carService, CustomerService customerService,
                PartService partService, SaleService saleService, SupplierService supplierService) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;

        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.mapper = new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        seedAll();

        //All the Below are exported in - src/main/resources/exports/

        orderedCustomers();

        carsFromMakeToyota();

        localSuppliers();

        carsWithTheirListOfParts();

        totalSalesByCustomer(); //there is a difference between the condition and the example, so I went with reverse order per the condition

        salesWithAppliedDiscount();
    }

    private void salesWithAppliedDiscount() {
        this.carService.exportSalesWithDiscount();
    }

    private void totalSalesByCustomer() {
        this.customerService.exportTotalSaleByCustomer();
    }

    private void carsWithTheirListOfParts() {
        this.carService.exportCarsAndParts();
    }

    private void localSuppliers() {
        this.supplierService.exportLocalSuppliers();
    }

    private void carsFromMakeToyota() {
        this.carService.exportCarsFromMakeToyota();
    }

    private void orderedCustomers() {
        this.customerService.exportOrderedCustomers();
    }

    private void seedSuppliers() {
        this.supplierService.seedData();
    }
    private void seedParts() {
        this.partService.seedData();
    }
    private void seedCars() {
        this.carService.seedData();
    }
    private void seedCustomers() {
        this.customerService.seedData();
    }
    private void seedSales() {
        this.saleService.seedData();
    }
    private void seedAll() {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }
}