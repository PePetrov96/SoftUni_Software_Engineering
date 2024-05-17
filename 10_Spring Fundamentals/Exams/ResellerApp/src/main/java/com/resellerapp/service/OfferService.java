package com.resellerapp.service;

import com.resellerapp.model.dto.OfferAddDTO;
import com.resellerapp.model.dto.OfferViewDTO;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;

import java.util.List;

public interface OfferService {
    List<OfferViewDTO> returnAllOffersForUser(Long id);
    void addOffer(OfferAddDTO offerAddDTO, User user);
    Offer getOfferById(Long id);
    void buyOffer(Long offerId, String username);
    void deleteOffer(Long id);
}
