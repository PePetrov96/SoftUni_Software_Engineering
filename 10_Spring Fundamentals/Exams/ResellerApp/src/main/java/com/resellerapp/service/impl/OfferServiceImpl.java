package com.resellerapp.service.impl;

import com.resellerapp.model.dto.OfferAddDTO;
import com.resellerapp.model.dto.OfferViewDTO;
import com.resellerapp.model.dto.UserViewDTO;
import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.entity.User;
import com.resellerapp.model.enums.ConditionName;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ConditionRepository conditionRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ModelMapper modelMapper, ConditionRepository conditionRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.conditionRepository = conditionRepository;
    }

    @Override
    public List<OfferViewDTO> returnAllOffersForUser(Long id) {
        List<Offer> offers = this.offerRepository
                .findOffersNotAssociatedWithUser(id);

        return returnAllOffersDTO(offers);
    }

    @Override
    public void addOffer(OfferAddDTO offerAddDTO, User sessionUser) {
        Offer offer = this.modelMapper.map(offerAddDTO, Offer.class);

        User user = this.userRepository.findUserByUsername(sessionUser.getUsername());

        ConditionName conditionName = ConditionName.valueOf(offerAddDTO.getCondition().toUpperCase());
        Condition condition = this.conditionRepository.findFirstByConditionName(conditionName);

        offer.setCondition(condition);

        offer.setBuyer(null);
        offer.setSeller(user);

        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public Offer getOfferById(Long id) {
        return this.offerRepository.getById(id);
    }

    @Override
    public void buyOffer(Long offerId, String username) {
        Offer offer = this.offerRepository.findById(offerId).get();
        User user = this.userRepository.findUserByUsername(username);

        offer.setBuyer(user);
        offer.setSeller(null);

        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.findById(id).ifPresent(this.offerRepository::delete);
    }

    private List<OfferViewDTO> returnAllOffersDTO(List<Offer> offers) {
        List<OfferViewDTO> offerViewDTOs = new ArrayList<>();

        offers.forEach(offer -> {
            OfferViewDTO offerToAdd = modelMapper.map(offer, OfferViewDTO.class);

            if (offer.getBuyer() != null) {
                offerToAdd.setBuyer(this.modelMapper.map(offer.getBuyer(), UserViewDTO.class));
            }

            if (offer.getSeller() != null) {
                offerToAdd.setSeller(this.modelMapper.map(offer.getSeller(), UserViewDTO.class));
            }

            offerViewDTOs.add(offerToAdd);
        });

        return offerViewDTOs;
    }
}
