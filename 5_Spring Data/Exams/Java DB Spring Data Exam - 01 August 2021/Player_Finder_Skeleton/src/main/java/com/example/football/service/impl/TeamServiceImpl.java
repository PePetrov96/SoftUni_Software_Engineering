package com.example.football.service.impl;

import com.example.football.models.dto.team.TeamCreateDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.util.ValidationUtils;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static com.example.football.constants.Messages.INVALID_TEAM;
import static com.example.football.constants.Messages.TEAM_IMPORTED;
import static com.example.football.constants.Paths.TEAMS_PATH;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtils validator;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TownRepository townRepository,
                           ModelMapper mapper, Gson gson, ValidationUtils validator) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() {
        try {
            return Files.readString(Path.of(TEAMS_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String importTeams() {
        StringBuilder out = new StringBuilder();

        TeamCreateDTO[] teamDTOs = this.gson.fromJson(readTeamsFileContent(), TeamCreateDTO[].class);

        for (TeamCreateDTO teamDTO : teamDTOs) {
            boolean isValid = this.validator.isValid(teamDTO);

            Optional<Town> town = this.townRepository.findTownByName(teamDTO.getTownName());
            Optional<Team> team = this.teamRepository.findTeamByName(teamDTO.getName());

            if (town.isEmpty() || team.isPresent()) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(TEAM_IMPORTED, teamDTO.getName(), teamDTO.getFanBase()));

                Team teamToSave = this.mapper.map(teamDTO, Team.class);
                teamToSave.setTown(town.get());

                this.teamRepository.saveAndFlush(teamToSave);
            } else {
                out.append(String.format(INVALID_TEAM));
            }
        }

        return out.toString().trim();
    }
}
