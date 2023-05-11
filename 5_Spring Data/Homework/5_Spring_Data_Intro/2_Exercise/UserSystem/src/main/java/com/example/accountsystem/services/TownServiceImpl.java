package com.example.accountsystem.services;

import com.example.accountsystem.model.Town;
import com.example.accountsystem.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TownServiceImpl implements TownService {
    private TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    @Transactional
    public void registerTown(Town town) {
        this.townRepository.save(town);
    }

    @Override
    public Town findByName(String name) {
        return this.townRepository
                .findTownByName(name)
                .orElse(null);
    }
}