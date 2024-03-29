package com.example.simplemapping;

import com.example.simplemapping.entities.dtos.AddressDTO;
import com.example.simplemapping.entities.dtos.CreateEmployeeDTO;
import com.example.simplemapping.entities.dtos.EmployeeDTO;
import com.example.simplemapping.services.AddressService;
import com.example.simplemapping.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class AppMain implements CommandLineRunner {
    private final AddressService addressService;
    private final EmployeeService employeeService;

    @Autowired
    public AppMain(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        createEmployee1();
        createEmployee2();
        createEmployee3();

        print();
    }

    private void print() {
        List<EmployeeDTO> employeeDTOS = this.employeeService.findAll();

        for (EmployeeDTO employee: employeeDTOS) {
            System.out.println(employee.toString());
        }
    }

    private void createEmployee1() {
        String firstName = "First";
        BigDecimal salary = new BigDecimal("10000");
        LocalDate birthday = LocalDate.parse("1999-01-01");

        String country = "Bulgaria";
        String city = "Sofia";

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName,
                null, salary, birthday, address);

        this.employeeService.create(employeeDTO);
    }

    private void createEmployee2() {
        String firstName = "Second";
        BigDecimal salary = new BigDecimal("10000");
        LocalDate birthday = LocalDate.parse("1996-01-01");
        String country = "Bulgaria";
        String city = "Sofia";

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName,
                null, salary, birthday, address);

        this.employeeService.create(employeeDTO);
    }

    private void createEmployee3() {
        String firstName = "Third";
        BigDecimal salary = new BigDecimal("10400");
        LocalDate birthday = LocalDate.parse("1993-01-01");

        String country = "Bulgaria";
        String city = "Plovdiv";

        AddressDTO address = new AddressDTO(country, city);

        CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName,
                null, salary, birthday, address);

        this.employeeService.create(employeeDTO);
    }
}