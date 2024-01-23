package com.project.spring.models.dto;

import com.project.spring.models.entity.enums.Engine;
import com.project.spring.models.entity.enums.Transmission;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OfferDTO extends BaseDTO{
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name must be minimum two characters!")
    private String description;

    @NotNull
    @NotEmpty
    private Engine engine;

    @NotNull
    @NotEmpty
    private String imageUrl;

    @NotNull
    @NotEmpty
    private Integer mileage;

    @NotNull
    @NotEmpty
    private Double price;

    @NotNull
    @NotEmpty
    private Transmission transmission;

    @NotNull
    @NotEmpty
    private Integer year;

    @NotNull
    @NotEmpty
    private LocalDateTime created;

    @NotNull
    @NotEmpty
    private LocalDateTime modified;

    @NotNull
    @NotEmpty
    private ModelDTO model;

    @NotNull
    @NotEmpty
    private UserDTO seller;
}
