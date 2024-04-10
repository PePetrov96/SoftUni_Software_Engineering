package com.project.spring.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyBindingModel {

    @NotNull(message = "Must be a positive number.")
    @Positive(message = "Must be a positive number.")
    private Double budget; // must be a positive number

    @NotNull
    @Size(min = 10, message = "Description length must be more than 10.")
    private String description; // Must be at least 10 characters.

    @NotNull
    @Size(min = 2, max = 10, message = "Name length must be between 2 and 10")
    private String name; // Must be between 2 and 10 characters.

    @NotNull
    @Size(min = 2, max = 10, message = "Town length must be between 2 and 10")
    private String town; // Must be between 2 and 10 characters.
}
