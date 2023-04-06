package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int inspectedSpots = 0;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        switch (kind) {
            case "Anthropologist":
                    this.discovererRepository.add(new Anthropologist(discovererName));
                break;
            case "Archaeologist":
                    this.discovererRepository.add(new Archaeologist(discovererName));
                break;
            case "Geologist":
                    this.discovererRepository.add(new Geologist(discovererName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);

        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        this.spotRepository.add(spot);

        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);

        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }

        this.discovererRepository.remove(discoverer);

        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Collection<Discoverer> discoverers = discovererRepository.getCollection()
                .stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (discoverers.isEmpty()) { //if there are no discoverers above 45 energy
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        int initial = discoverers.size(); //count of discoverers that canDig() before the expedition

        Spot spot = spotRepository.byName(spotName); //get the spot

        Operation operation = new OperationImpl(); //make a new Operation

        operation.startOperation(spot, discoverers); //start the operation

        this.inspectedSpots++;

        long remaining = discoverers.stream()
                .filter(Discoverer::canDig).count(); //count of discoverers that canDig() after the expedition

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, (initial - remaining));
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder(String.format(ConstantMessages.FINAL_SPOT_INSPECT, inspectedSpots))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());

        for (Discoverer discoverer : discovererRepository.getCollection()) {
            out
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                out.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        "None"));
            } else {
                out.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits())));
            }

            out.append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}