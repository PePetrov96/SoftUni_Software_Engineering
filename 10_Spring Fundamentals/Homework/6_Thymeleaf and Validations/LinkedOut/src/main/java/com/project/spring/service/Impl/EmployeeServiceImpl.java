package com.project.spring.service.Impl;

import com.project.spring.models.dto.EmployeeBindingModel;
import com.project.spring.models.entity.Employee;
import com.project.spring.repository.EmployeeRepository;
import com.project.spring.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void save(EmployeeBindingModel employeeBindingModel) {
        Employee employee = this.modelMapper.map(employeeBindingModel, Employee.class);
        employee.setBirthdate(LocalDate.parse(employeeBindingModel.getBirthdate()));
        this.employeeRepository.saveAndFlush(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findFirstById(id);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = this.employeeRepository.findFirstById(id);
        this.employeeRepository.delete(employee);
    }
}
