package com.project.spring.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferDTO extends BaseDTO{
    @NotEmpty(message = "descriptionEmpty")
    private String description;

    @NotEmpty(message = "engineEmpty")
    private String engine;

    @NotEmpty(message = "imageUrlEmpty")
    private String imageUrl;

    @NotNull(message = "mileageEmpty")
    private Integer mileage;

    @NotNull(message = "priceEmpty")
    private Double price;

    @NotEmpty(message = "transmissionEmpty")
    private String transmission;

    @NotNull(message = "yearEmpty")
    private Integer year;

    @NotNull(message = "modelEmpty")
    private Long model;

    private Long seller;
}
