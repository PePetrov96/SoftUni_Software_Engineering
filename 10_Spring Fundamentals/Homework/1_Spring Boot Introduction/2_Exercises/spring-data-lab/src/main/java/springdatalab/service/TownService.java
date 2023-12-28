package springdatalab.service;

import springdatalab.models.entities.Town;

public interface TownService {

    void addTown(String townName);

    Town findTownByName(String townName);
}
