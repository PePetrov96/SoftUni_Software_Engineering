package com.example.accountsystem;

import com.example.accountsystem.dtos.EmployeeDto;
import com.example.accountsystem.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final EmployeeService employeeService;

    public CommandLineRunnerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) {
        addEmployee();
    }

    private void addEmployee(){
        EmployeeDto employeeDto = new EmployeeDto(
                "Peter",
                "Petrov",
                new BigDecimal("5000"));

        this.employeeService.registerEmployee(employeeDto);
    }
}