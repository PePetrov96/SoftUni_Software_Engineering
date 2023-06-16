package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentCreateDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import static softuni.exam.constants.Messages.IMPORT_AGENT;
import static softuni.exam.constants.Messages.INVALID_AGENT;
import static softuni.exam.constants.Paths.AGENTS_PATH;

@Service
public class AgentServiceImpl implements AgentService {
    private final TownRepository townRepository;
    private final AgentRepository agentRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final ValidationUtils validator;

    @Autowired
    public AgentServiceImpl(TownRepository townRepository, AgentRepository agentRepository,
                            ModelMapper mapper, Gson gson, ValidationUtils validator) {
        this.townRepository = townRepository;
        this.agentRepository = agentRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder out = new StringBuilder();

        AgentCreateDTO[] agentDTOs = this.gson.fromJson(readAgentsFromFile(), AgentCreateDTO[].class);

        for (AgentCreateDTO agentDTO : agentDTOs) {
            boolean isValid = this.validator.isValid(agentDTO);

            if (this.agentRepository.findAgentByFirstName(agentDTO.getFirstName()).isPresent()) {
                isValid = false;
            }

            Optional<Town> town = this.townRepository.findTownByTownName(agentDTO.getTown());

            if (town.isEmpty()) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(IMPORT_AGENT, agentDTO.getFirstName(), agentDTO.getLastName()));

                Agent agent = this.mapper.map(agentDTO, Agent.class);
                agent.setTown(town.get());

                this.agentRepository.saveAndFlush(agent);

            } else {
                out.append(String.format(INVALID_AGENT));
            }
        }

        return out.toString().trim();
    }
}
