package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<Explorer> explorersGoing = explorers.stream()
                .filter(Explorer::canSearch)
                .collect(Collectors.toList());

        List<String> exhibits = state.getExhibits()
                .stream()
                .collect(Collectors.toList());

        for (int i = 0; i < exhibits.size(); i++) {
            String currExhibit = exhibits.get(i);

            for (Explorer explorer : explorersGoing) {

                if (explorer.canSearch()) {

                    explorer.search();
                    explorer.getSuitcase().getExhibits().add(currExhibit);
                    state.getExhibits().remove(currExhibit);
                    break;
                }
            }
        }

    }
}