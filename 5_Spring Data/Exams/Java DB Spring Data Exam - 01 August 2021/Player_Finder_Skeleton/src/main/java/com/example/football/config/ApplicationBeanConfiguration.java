package com.example.football.config;

import com.example.football.models.dto.player.PlayerCreateDTO;
import com.example.football.models.dto.team.TeamCreateDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;

    @Autowired
    public ApplicationBeanConfiguration(TeamRepository teamRepository, TownRepository townRepository,
                                        StatRepository statRepository) {
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
}
