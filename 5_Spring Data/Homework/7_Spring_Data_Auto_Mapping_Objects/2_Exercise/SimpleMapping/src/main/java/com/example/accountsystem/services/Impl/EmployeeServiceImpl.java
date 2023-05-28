package com.example.accountsystem.services.Impl;

import com.example.accountsystem.dtos.EmployeeDto;
import com.example.accountsystem.model.Employee;
import com.example.accountsystem.repositories.EmployeeRepository;
import com.example.accountsystem.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerEmployee(EmployeeDto employeeDto) {
        Employee employee = this.modelMapper.map(employeeDto, Employee.class);
        this.employeeRepository.save(employee);
    }
}