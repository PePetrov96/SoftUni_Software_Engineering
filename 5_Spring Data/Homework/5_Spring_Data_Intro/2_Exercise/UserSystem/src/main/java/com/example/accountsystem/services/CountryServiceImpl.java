package com.example.accountsystem.services;

import com.example.accountsystem.model.Country;
import com.example.accountsystem.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional
    public void registerCountry(Country country) {
        this.countryRepository.save(country);
    }

    @Override
    public Country findByName(String name) {
        return this.countryRepository
                .findCountriesByName(name)
                .orElse(null);
    }
}