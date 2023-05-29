package com.example.gamestore.repositories;

import com.example.gamestore.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    boolean existsByTitle(String title);
    Optional<Game> findById(Long id);
    void deleteById(Long id);

    List<Game> findAll();
    Optional<Game> findByTitle(String title);
}