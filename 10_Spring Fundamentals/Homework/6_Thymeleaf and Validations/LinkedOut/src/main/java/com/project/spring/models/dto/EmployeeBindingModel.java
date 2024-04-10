package com.project.spring.models.dto;

import com.project.spring.models.entity.Company;
import com.project.spring.validation.PastDate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeBindingModel {
    @PastDate
    @NotEmpty(message = "Please select date.")
    private String birthdate;

    @NotNull(message = "Please select education level.")
    private String educationLevel;

    @NotNull
    @Size(min = 2, message = "Name length must be at least 2 characters.")
    private String firstName; // Must be at least 2 characters.

    @NotEmpty(message = "Please fill in your job title.")
    private String jobTitle;

    @NotNull
    @Size(min = 2, message = "Name length must be at least 2 characters.")
    private String lastName; // Must be at least 2 characters.

    @NotNull
    @Positive(message = "Must be a positive number.")
    private Double salary; // Must be a positive number.

    @NotNull(message = "Please select company.")
    private Company company;
}
