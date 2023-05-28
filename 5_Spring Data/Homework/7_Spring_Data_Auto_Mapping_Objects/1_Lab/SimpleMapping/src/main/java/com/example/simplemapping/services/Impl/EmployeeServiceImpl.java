package com.example.simplemapping.services.Impl;

import com.example.simplemapping.entities.Address;
import com.example.simplemapping.entities.Employee;
import com.example.simplemapping.entities.dtos.CreateEmployeeDTO;
import com.example.simplemapping.repositories.AddressRepository;
import com.example.simplemapping.repositories.EmployeeRepository;
import com.example.simplemapping.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public Employee create(CreateEmployeeDTO employeeDTO) {
        ModelMapper mapper = new ModelMapper();

        Employee employee = mapper.map(employeeDTO, Employee.class);

        Optional<Address> address = this.addressRepository.findByCountryAndCity(employeeDTO.getAddress().getCountry(),
                employeeDTO.getAddress().getCity());

        address.ifPresent(employee::setAddress);

        return employeeRepository.save(employee);
    }
}
