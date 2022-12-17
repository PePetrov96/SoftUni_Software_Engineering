public class Cat {
    private final String name;
    private StreetExtraordinaire streetExtraordinaire;
    private Siamese siamese;
    private Cymric cymric;

    public Cat(String name, StreetExtraordinaire streetExtraordinaire) {
        this.name = name;
        this.streetExtraordinaire = streetExtraordinaire;
    }

    public Cat(String name, Siamese siamese) {
        this.name = name;
        this.siamese = siamese;
    }

    public Cat(String name, Cymric cymric) {
        this.name = name;
        this.cymric = cymric;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (this.streetExtraordinaire != null) {
            return String.format("%s %s %s", streetExtraordinaire.getBreed(), this.name, streetExtraordinaire.getDecibelsOfMeows());
        } else if (this.siamese != null) {
            return String.format("%s %s %s", siamese.getBreed(), this.name, siamese.getEarSize());
        } else {
            return String.format("%s %s %s", cymric.getBreed(), this.name, cymric.getFurLength());
        }
    }
}