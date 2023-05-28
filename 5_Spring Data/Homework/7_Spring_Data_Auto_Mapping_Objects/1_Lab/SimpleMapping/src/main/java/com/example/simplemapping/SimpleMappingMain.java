package com.example.simplemapping;

import com.example.simplemapping.entities.Address;
import com.example.simplemapping.entities.Employee;
import com.example.simplemapping.entities.dtos.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SimpleMappingMain implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ModelMapper mapper = new ModelMapper();
//
//        PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
//            @Override
//            protected void configure() {
//                map().setCity(source.getAddress().getCity());
//            }
//        };
//        mapper.addMappings(propertyMap);
        TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);

        typeMap.addMappings(mapping -> mapping.map(
                source -> source.getAddress().getCity(),
                EmployeeDTO::setCity)
        );

        Address address = new Address("Bulgaria", "Sofia");
        Employee employee = new Employee("Peter", new BigDecimal("20000"), address);

        EmployeeDTO employeeDTO = typeMap.map(employee);

        System.out.println(employeeDTO);
    }
}