package com.example.accountsystem.services;

import com.example.accountsystem.model.Country;

public interface CountryService {
    void registerCountry(Country country);
    Country findByName(String name);
}