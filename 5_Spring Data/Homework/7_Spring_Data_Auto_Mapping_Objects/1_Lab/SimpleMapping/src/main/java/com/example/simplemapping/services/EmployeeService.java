package com.example.simplemapping.services;

import com.example.simplemapping.entities.Employee;
import com.example.simplemapping.entities.dtos.CreateEmployeeDTO;
import com.example.simplemapping.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employee);
    List<EmployeeDTO> findAll();
}
