package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> items = new ArrayList<>(planet.getItems()); // all the items on the plant

        for (Astronaut astronaut : astronauts) { // while there are available astronauts
            if (items.isEmpty() && !astronaut.canBreath()) { // if there are no more items -> break
                break;
            }

            for (int i = 0; i < items.size() && astronaut.canBreath(); i++) { //while the current astronaut can breathe and there are items on the planet (in the collection)
                String item = items.get(i);// get the first item in the collection
                items.remove(item); // remove it from the collection
                i--; //revert to the previous i - so we can iterate through all Items

                astronaut.getBag().getItems().add(item); //add the item inside the astronaut's bag
                astronaut.breath(); //breathe
            }
            //once the astronaut has no breath, we go to the next astronaut
        }
    }
}