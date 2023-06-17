package com.example.football.service.impl;

import com.example.football.models.dto.player.PlayerCreateDTO;
import com.example.football.models.dto.wrappers.PlayersWrapper;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.util.ValidationUtils;
import org.apache.tomcat.jni.Local;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.example.football.constants.Messages.*;
import static com.example.football.constants.Paths.PLAYERS_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper mapper;
    private final ValidationUtils validator;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TownRepository townRepository,
                             StatRepository statRepository, TeamRepository teamRepository,
                             ModelMapper mapper, ValidationUtils validator) {
        this.playerRepository = playerRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() {
        try {
            return Files.readString(Path.of(PLAYERS_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String importPlayers()  {
        StringBuilder out = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(PLAYERS_PATH))) {
            JAXBContext context = JAXBContext.newInstance(PlayersWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            PlayersWrapper playersWrapper = (PlayersWrapper) unmarshaller.unmarshal(reader);

            for (PlayerCreateDTO playerDTO : playersWrapper.getPlayers()) {
                boolean isValid = this.validator.isValid(playerDTO);

                Optional<Player> optionalPlayer = this.playerRepository.findPlayerByEmail(playerDTO.getEmail());
                Optional<Town> town = this.townRepository.findTownByName(playerDTO.getTown().getName());
                Optional<Team> team = this.teamRepository.findTeamByName(playerDTO.getTeam().getName());
                Optional<Stat> stat = this.statRepository.findById(playerDTO.getStat().getId());

                if (optionalPlayer.isPresent() || town.isEmpty() || team.isEmpty() || stat.isEmpty()) {
                    isValid = false;
                }

                if (isValid) {
                    out.append(String.format(PLAYER_IMPORTED, playerDTO.getFirstName(), playerDTO.getLastName(), playerDTO.getPosition().name()));
                    LocalDate birthDate = LocalDate.parse(playerDTO.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Player player = new Player(
                            playerDTO.getFirstName(),
                            playerDTO.getLastName(),
                            playerDTO.getEmail(),
                            birthDate,
                            playerDTO.getPosition(),
                            team.get(),
                            town.get(),
                            stat.get());

                    this.playerRepository.saveAndFlush(player);

                } else {
                    out.append(String.format(INVALID_PLAYER));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toString().trim();
    }

    @Override
    public String exportBestPlayers() {
        LocalDate after = LocalDate.of(1995, 1, 1);
        LocalDate before = LocalDate.of(2003, 1, 1);

        List<Player> players = this.playerRepository
                .findPlayersByBirthDateAfterAndBirthDateBeforeOrderByStat_ShootingDescStat_PassingDescStat_EnduranceDescLastName(after, before);

        StringBuilder out = new StringBuilder();

        for (Player player : players) {
            out.append(String.format(EXPORT_PLAYERS,
                    player.getFirstName(),
                    player.getLastName(),
                    player.getPosition(),
                    player.getTeam().getName(),
                    player.getTeam().getStadiumName()));
        }

        return out.toString().trim();
    }
}
