package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class OperationImpl implements Operation{
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        List<String> exhibits = new ArrayList<>(spot.getExhibits());

        for (Discoverer discoverer : discoverers) { //For each discoverer

            while (discoverer.canDig() && !exhibits.isEmpty()) { //while the discoverer can dig and there are exhibits

                discoverer.dig(); //use up energy to dig
                discoverer.getMuseum().getExhibits().add(exhibits.get(0)); //add the exhibit to the personal museum (bag)
                exhibits.remove(0); //remove the exhibit from the exhibits on the Spot
            }
        }
    }
}