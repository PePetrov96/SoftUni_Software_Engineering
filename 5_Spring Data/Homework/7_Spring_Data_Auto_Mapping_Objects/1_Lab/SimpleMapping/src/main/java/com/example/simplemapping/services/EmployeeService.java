package com.example.simplemapping.services;

import com.example.simplemapping.entities.Employee;
import com.example.simplemapping.entities.dtos.CreateEmployeeDTO;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO employee);
}
