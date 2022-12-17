public class StreetExtraordinaire {
    private final String breed;
    private final double decibelsOfMeows;

    public StreetExtraordinaire(double decibelsOfMeows) {
        this.breed = "StreetExtraordinaire";
        this.decibelsOfMeows = decibelsOfMeows;
    }
    public String getDecibelsOfMeows() {
        return String.format("%.2f", decibelsOfMeows);
    }
    public String getBreed() {
        return breed;
    }
}