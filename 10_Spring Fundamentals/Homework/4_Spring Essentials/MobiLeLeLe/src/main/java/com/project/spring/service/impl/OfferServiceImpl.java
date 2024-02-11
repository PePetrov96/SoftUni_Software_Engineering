package com.project.spring.service.impl;

import com.project.spring.models.dto.OfferDTO;
import com.project.spring.models.entity.Model;
import com.project.spring.models.entity.Offer;
import com.project.spring.models.entity.User;
import com.project.spring.models.entity.enums.Engine;
import com.project.spring.models.entity.enums.Transmission;
import com.project.spring.repository.ModelRepository;
import com.project.spring.repository.OfferRepository;
import com.project.spring.repository.UserRepository;
import com.project.spring.service.OfferService;
import com.project.spring.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository,
                            UserRepository userRepository, ModelMapper mapper, ValidationUtil validator) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public List<Offer> postOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer getOffer(Long id) {
        return this.offerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Offer Id"));
    }


    @Override
    public List<String> addOffer(OfferDTO offerDTO, String username) {
        if (this.validator.isValid(offerDTO)) {
            Model model = this.modelRepository
                    .findById(offerDTO.getModel())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid model"));

            User fetchedUser = this.userRepository
                    .findUserByUsername(username)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

            Offer offer = mapToOffer(offerDTO, model, fetchedUser);

            this.offerRepository.saveAndFlush(offer);
            return null;
        } else {
            return offerErrors(offerDTO);
        }

    }

    @Override
    public List<String> updateOffer(Offer offer, OfferDTO offerDTO) {
        if (this.validator.isValid(offerDTO)) {
            offer.setModified(LocalDateTime.now());

            offer.setDescription(offerDTO.getDescription());
            offer.setEngine(Engine.valueOf(offerDTO.getEngine()));
            offer.setImageUrl(offerDTO.getImageUrl());
            offer.setMileage(offerDTO.getMileage());
            offer.setPrice(offerDTO.getPrice());
            offer.setTransmission(Transmission.valueOf(offerDTO.getTransmission()));
            offer.setYear(offerDTO.getYear());

            this.offerRepository.save(offer);

            return null;
        }
        else {
            return offerErrors(offerDTO);
        }
    }

    @Override
    public void deleteOffer(Long id) {
        Offer offer = this.offerRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Offer Id"));

        this.offerRepository.delete(offer);
    }

    private List<String> offerErrors(OfferDTO offerDTO) {
        Set<ConstraintViolation<OfferDTO>> violations = this.validator.violations(offerDTO);

        List<String> errors = new ArrayList<>();

        for (ConstraintViolation<OfferDTO> violation : violations) {
            errors.add(violation.getMessage());
        }
        return errors;
    }

    private Offer mapToOffer(OfferDTO offerDTO, Model model, User user) {
        Offer offer = mapper.map(offerDTO, Offer.class);

        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());

        offer.setModel(model);
        offer.setSeller(user);

        return offer;
    }
}