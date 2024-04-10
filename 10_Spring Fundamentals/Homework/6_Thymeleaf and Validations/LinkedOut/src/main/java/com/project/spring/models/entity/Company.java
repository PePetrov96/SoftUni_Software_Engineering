package com.project.spring.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company extends BaseModel {
    @Column(name = "budget", nullable = false, columnDefinition = "DECIMAL(19,2)")
    private Double budget; // must be a positive number

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description; // Must be at least 10 characters.

    @Column(name = "name", nullable = false, unique = true)
    private String name; // Must be between 2 and 10 characters.

    @Column(name = "town", nullable = false)
    private String town; // Must be between 2 and 10 characters.

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
