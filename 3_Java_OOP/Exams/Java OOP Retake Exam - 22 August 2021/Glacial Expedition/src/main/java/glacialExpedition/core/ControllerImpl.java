package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private final Repository<Explorer> explorerRepository;
    private final Repository<State> stateRepository;
    private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        switch (type) {
            case "AnimalExplorer": explorerRepository.add(new AnimalExplorer(explorerName));
                break;
            case "GlacierExplorer": explorerRepository.add(new GlacierExplorer(explorerName));
                break;
            case "NaturalExplorer": explorerRepository.add(new NaturalExplorer(explorerName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibit: exhibits) {
            state.getExhibits().add(exhibit);
        }

        stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        Collection<Explorer> explorersGoing = explorerRepository.getCollection()
                .stream()
                .filter(explorer -> explorer.getEnergy() > 50)
                .collect(Collectors.toList());

        if (explorersGoing.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = stateRepository.byName(stateName);

        Mission mission = new MissionImpl();

        mission.explore(state, explorersGoing);
        exploredStates++;

        long retired = explorersGoing.size() - explorersGoing.stream().filter(Explorer::canSearch).count();

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {
        StringBuilder out = new StringBuilder(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStates))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());

        for (Explorer explorer : explorerRepository.getCollection()) {
            out.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator());

            if (explorer.getSuitcase().getExhibits().size() == 0) {
                out.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                out.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }

            out.append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}