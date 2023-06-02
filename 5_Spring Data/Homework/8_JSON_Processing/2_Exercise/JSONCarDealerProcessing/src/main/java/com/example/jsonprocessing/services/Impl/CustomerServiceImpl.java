package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.config.GsonBuilderWrapper;
import com.example.jsonprocessing.model.Customer;
import com.example.jsonprocessing.model.DTOs.CustomerCreateFromJsonDTO;
import com.example.jsonprocessing.model.DTOs.CustomerJsonExportDTO;
import com.example.jsonprocessing.repositories.CustomerRepository;
import com.example.jsonprocessing.services.CustomerService;
import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;

        this.mapper = modelMapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd")
                .create();
    }

    @Override
    @Transactional
    public void seedData() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/customers.json"))) {

            CustomerCreateFromJsonDTO[] customerDtos = gson.fromJson(reader, CustomerCreateFromJsonDTO[].class);

            for (CustomerCreateFromJsonDTO customerDto : customerDtos) {
                Customer customer = new Customer();

                customer.setName(customerDto.getName());

                // Parse the date string to LocalDateTime
                customer.setBirthDate(LocalDate.parse(customerDto.getBirthDate(), DateTimeFormatter.ISO_DATE_TIME));

                customer.setYoungDriver(customerDto.isYoungDriver());

                this.customerRepository.save(customer);
            }

            this.customerRepository.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void exportOrderedCustomers() {
        List<Customer> orderedCustomers = this.customerRepository.getCustomersOrderedByBirthdateAndAndYoungDriver();

        List<CustomerJsonExportDTO> exportDTOs = orderedCustomers.stream()
                .map(this::convertCustomerJsonExport1)
                .collect(Collectors.toList());

        List<String> fields = new ArrayList<>(); fields.add("boughtCars");
        Gson gsonNew = new GsonBuilderWrapper(fields).createGson();

        String filePath = "src/main/resources/exports/Task_1_Ordered_Customers.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gsonNew.toJson(exportDTOs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CustomerJsonExportDTO convertCustomerJsonExport1(Customer customer) {
        return new CustomerJsonExportDTO(
                customer.getId(),
                customer.getName(),
                customer.getBirthDate(),
                customer.isYoungDriver());
    }

    @Override
    @Transactional(readOnly = true)
    public void exportTotalSaleByCustomer() {
        List<Customer> customers = this.customerRepository.getCustomersBySalesNotEmpty();

        List<CustomerJsonExportDTO> exportDTOs = new ArrayList<>(customers.stream()
                .map(this::convertCustomerJsonExport2)
                .toList());

        exportDTOs.sort(
                Comparator.comparing(CustomerJsonExportDTO::getSpentMoney)
                        .reversed() //in the example it is in Ascending order, int the condition it is Descending order
                        .thenComparing(CustomerJsonExportDTO::getBoughtCars)
                        .reversed());  //in the example it is in Ascending order, int the condition it is Descending order

        List<String> fields = new ArrayList<>(); fields.add("IsYoungDriver");
        Gson gsonNew = new GsonBuilderWrapper(fields).createGson();

        String filePath = "src/main/resources/exports/Task_5_Total_Sales_by_Customer.json";

        try (FileWriter writer = new FileWriter(filePath)) {
            gsonNew.toJson(exportDTOs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private CustomerJsonExportDTO convertCustomerJsonExport2(Customer customer) {
        return new CustomerJsonExportDTO(
                customer.getName(),
                customer.getSales());
    }
}