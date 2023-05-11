package com.example.accountsystem.services;

import com.example.accountsystem.model.Town;

public interface TownService {
    void registerTown(Town town);
    Town findByName(String name);
}