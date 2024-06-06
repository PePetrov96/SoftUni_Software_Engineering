package com.project.spring.service;

import com.project.spring.models.dto.OfferDTO;
import com.project.spring.models.entity.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> postOffers();
    List<String> addOffer(OfferDTO offer, String username);
    Offer getOffer(Long id);
    void deleteOffer(Long id);
    List<String> updateOffer(Offer offer, OfferDTO offerDTO);
}
