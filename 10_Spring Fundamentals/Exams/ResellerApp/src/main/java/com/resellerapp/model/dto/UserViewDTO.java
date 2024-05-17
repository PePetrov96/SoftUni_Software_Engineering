package com.resellerapp.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
public class UserViewDTO {
    private String username;
    private String email;
    private Set<OfferViewDTO> offers = new HashSet<>();
    private Set<OfferViewDTO> boughtOffers = new HashSet<>();
}
