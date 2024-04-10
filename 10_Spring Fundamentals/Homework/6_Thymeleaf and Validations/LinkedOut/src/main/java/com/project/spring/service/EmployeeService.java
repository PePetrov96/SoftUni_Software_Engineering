package com.project.spring.service;

import com.project.spring.models.dto.EmployeeBindingModel;
import com.project.spring.models.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void save(EmployeeBindingModel employeeBindingModel);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
