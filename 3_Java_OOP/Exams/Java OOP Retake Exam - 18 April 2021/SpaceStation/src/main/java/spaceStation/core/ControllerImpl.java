package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private final Repository<Astronaut> astronautRepository;
    private final Repository<Planet> planetRepository;

    private int exploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        switch (type) {
            case "Biologist": astronautRepository.add(new Biologist(astronautName));
                break;
            case "Geodesist": astronautRepository.add(new Geodesist(astronautName));
                break;
            case "Meteorologist": astronautRepository.add(new Meteorologist(astronautName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String item : items) {
            planet.getItems().add(item);
        }

        planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);

        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(astronaut);

        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);  // get the planet
        Collection<Astronaut> astronauts = new ArrayList<>();  // create astronaut list

        astronautRepository.getModels()  // get all astronauts that match the criteria
                .stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .forEach(astronauts::add);

        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);  // in case no astronaut covers the criteria
        }

        Mission mission = new MissionImpl();
        mission.explore(planet, astronauts);
        exploredPlanets++;

        long count = astronauts.stream().filter(astronaut -> !astronaut.canBreath()).count();

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, count);
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, exploredPlanets))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());

        for (Astronaut astronaut : astronautRepository.getModels()) {
            out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator());

            if (astronaut.getBag().getItems().isEmpty()) {
                out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
            } else {
                out.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                        String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER,
                                astronaut.getBag().getItems())));
            }

            out.append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}