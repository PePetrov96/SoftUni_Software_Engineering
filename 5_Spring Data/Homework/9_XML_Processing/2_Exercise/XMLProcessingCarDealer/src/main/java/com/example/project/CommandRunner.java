package com.example.project;

import com.example.project.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    private final CarService carService;
    private final CustomerService customerService;
    private final PartService partService;
    private final SaleService saleService;
    private final SupplierService supplierService;
    private final SeedService seedService;

    @Autowired
    public CommandRunner(CarService carService, CustomerService customerService,
                         PartService partService, SaleService saleService,
                         SupplierService supplierService, SeedService seedService) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedAll();

        Task_1_Ordered_Customers();

        Task_2_Cars_from_Make_Toyota();

        Task_3_Local_Suppliers();

        Task_4_Cars_with_Their_List_of_Parts();

        Task_5_Total_Sales_by_Customer();

        Task_6_Sales_with_Applied_Discount();
    }

    private void Task_1_Ordered_Customers() {
        this.customerService.exportOrderedCustomers();
    }

    private void Task_2_Cars_from_Make_Toyota() {
        this.carService.exportToyotaCars();
    }

    private void Task_3_Local_Suppliers() {
        this.supplierService.exportLocalSuppliers();
    }

    private void Task_4_Cars_with_Their_List_of_Parts() {
        this.carService.exportCartsWithParts();
    }

    private void Task_5_Total_Sales_by_Customer() {
        this.customerService.exportCustomerSales();
    }

    private void Task_6_Sales_with_Applied_Discount() {
        this.saleService.exportSalesWithDiscounts();
    }

    private void seedAll() {
        this.seedService.seedSuppliers();
        this.seedService.seedParts();
        this.seedService.seedCars();
        this.seedService.seedCustomers();
        this.seedService.seedSales();
    }
}
