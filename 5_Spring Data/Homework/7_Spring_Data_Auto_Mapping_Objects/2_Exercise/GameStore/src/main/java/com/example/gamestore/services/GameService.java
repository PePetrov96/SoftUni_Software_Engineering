package com.example.gamestore.services;


import com.example.gamestore.model.Game;
import com.example.gamestore.model.dtos.GameDto;

import java.util.List;

public interface GameService {
    void create(String[] data);
    boolean existsByTitle(String title);
    String editGame(String[] data);
    String deleteGame(Long id);
    List<GameDto> getAllGames();
    GameDto getGameByTitle(String title);
    Game findGameByTitle(String title);
}