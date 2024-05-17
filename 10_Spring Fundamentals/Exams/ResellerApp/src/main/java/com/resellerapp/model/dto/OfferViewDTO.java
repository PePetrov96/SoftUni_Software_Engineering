package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class OfferViewDTO {
    private Long id;
    private String description;
    private Double price;
    private Condition condition;
    private UserViewDTO buyer;
    private UserViewDTO seller;
}
