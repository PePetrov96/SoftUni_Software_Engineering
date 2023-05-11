package com.example.accountsystem.repositories;

import com.example.accountsystem.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Optional<Town> findTownByCountry(String country);
    Optional<Town> findTownByName(String name);

    List<Town> findAll();
}