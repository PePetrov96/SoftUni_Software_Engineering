package com.example.advquerying.repositories;

import com.example.advquerying.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {
    Optional<Label> findById(Long id);
}