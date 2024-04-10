package com.project.spring.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee extends BaseModel{
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "education_level", nullable = false)
    private String educationLevel;

    @Column(name = "first_name", nullable = false)
    private String firstName; // Must be at least 2 characters.

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "last_name", nullable = false)
    private String lastName; // Must be at least 2 characters.

    @Column(name = "salary", nullable = false, columnDefinition = "DECIMAL(19,2)")
    private Double salary; // Must be a positive number.

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public void addCompany(Company company) {
        this.company = company;
        company.addEmployee(this);
    }
}
