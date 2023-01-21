package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public class Archaeologist extends BaseDiscoverer{
    private static final double ENERGY = 60;

    public Archaeologist(String name) {
        super(name, ENERGY);
    }
}