package com.example.simplemapping.entities.dtos;

import java.math.BigDecimal;

public class EmployeeDTO {
    private String firstName;
    private BigDecimal salary;
    private String city;

    public EmployeeDTO() {
    }

    @Override
    public String toString() {
        return String.format("- %s %s %.2f %s", getFirstName(), getFirstName(), getSalary(), getCity());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}