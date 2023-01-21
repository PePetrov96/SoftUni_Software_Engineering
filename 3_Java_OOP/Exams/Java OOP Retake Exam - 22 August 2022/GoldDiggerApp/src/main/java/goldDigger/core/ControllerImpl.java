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
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private final Repository<Discoverer> discovererRepository;
    private final Repository<Spot> spotRepository;
    private int count;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        switch (kind) {
            case "Archaeologist": this.discovererRepository.add(new Archaeologist(discovererName));
                break;
            case "Anthropologist": this.discovererRepository.add(new Anthropologist(discovererName));
                break;
            case "Geologist": this.discovererRepository.add(new Geologist(discovererName));
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
        Collection<Discoverer> discoverParty = this.discovererRepository.getCollection()
                .stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (discoverParty.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot spot = spotRepository.byName(spotName);

        Operation operation = new OperationImpl();
        operation.startOperation(spot, discoverParty);

        long excluded = discoverParty.stream().filter(discoverer -> discoverer.getEnergy() == 0).count();
        this.count++;

        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excluded);
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder(
                String.format(ConstantMessages.FINAL_SPOT_INSPECT, this.count))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_DISCOVERER_INFO)
                .append(System.lineSeparator());

        for (Discoverer discoverer : this.discovererRepository.getCollection()) {

            result.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, discoverer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, discoverer.getEnergy()))
                    .append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().size() == 0) {
                result.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS
                        , "None"));
            } else {
                result.append(String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS,
                        (String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits()))));
            }

            result.append(System.lineSeparator());

        }

        return result.toString().trim();
    }
}