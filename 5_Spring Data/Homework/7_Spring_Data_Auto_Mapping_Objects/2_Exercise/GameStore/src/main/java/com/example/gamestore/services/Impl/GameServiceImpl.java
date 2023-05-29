package com.example.gamestore.services.Impl;

import com.example.gamestore.model.Game;
import com.example.gamestore.model.dtos.GameDto;
import com.example.gamestore.repositories.GameRepository;
import com.example.gamestore.services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public void create(String[] data) {
        String title = data[0];
        String trailer = data[3];
        String thumbnail = data[4];
        BigDecimal size = new BigDecimal(data[2]);
        BigDecimal price = new BigDecimal(data[1]);
        String description = data[5];
        LocalDate releaseDate = LocalDate.parse(data[6], DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        if (this.gameRepository.existsByTitle(title)) {
            throw new IllegalArgumentException("Game already exists");
        }

        try {
            Game game = new Game(title, trailer, thumbnail, size, price, description, releaseDate);
            this.gameRepository.save(game);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public boolean existsByTitle(String title) {
        return this.gameRepository.existsByTitle(title);
    }
    @Override
    @Transactional
    public String editGame(String[] data) {
        Long id = Long.parseLong(data[0]);
        Optional<Game> optionalGame = this.gameRepository.findById(id);

        Game game = optionalGame.orElseThrow(() -> new IllegalArgumentException("Game does not exist"));

        for (int i = 1; i < data.length; i++) {
            String[] command = data[i].split("=");

            if (command.length == 2) {
                String variable = command[0];
                String value = command[1];

                try {
                    switch (variable) {
                        case "title": game.setTitle(value);
                            break;
                        case "price": game.setPrice(new BigDecimal(value));
                            break;
                        case "size": game.setSize(new BigDecimal(value));
                            break;
                        case "trailer": game.setTrailer(value);
                            break;
                        case "thumbnailURL": game.setImageThumbnail(value);
                            break;
                        case "description": game.setDescription(value);
                            break;
                        case "releaseDate": game.setReleaseDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                            break;
                        default: System.out.println("Invalid variable: " + variable);
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Invalid command format: " + data[i]);
            }
        }
        this.gameRepository.save(game);
        return game.getTitle();
    }
    @Override
    @Transactional
    public String deleteGame(Long id) {
        Optional<Game> optionalGame = this.gameRepository.findById(id);
        Game game = optionalGame.orElseThrow(() -> new IllegalArgumentException("Game does not exist"));
        this.gameRepository.delete(game);
        return game.getTitle();
    }

    @Override
    @Transactional
    public List<GameDto> getAllGames() {
        ModelMapper mapper = new ModelMapper();

        List<Game> gameList = this.gameRepository.findAll();

        return gameList.stream()
                .map(game -> mapper.map(game, GameDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GameDto getGameByTitle(String title) {
        ModelMapper mapper = new ModelMapper();

        Optional<Game> game = this.gameRepository.findByTitle(title);
        GameDto gameDto = mapper.map(game, GameDto.class);

        if (game.isPresent()) {
            return gameDto;
        } else {
            throw new IllegalArgumentException("Game not found");
        }
    }

    @Override
    public Game findGameByTitle(String title) {
        Optional<Game> game = this.gameRepository.findByTitle(title);
        if (game.isPresent()) {
            return game.get();
        } else {
            throw new IllegalArgumentException("Game not found");
        }
    }
}