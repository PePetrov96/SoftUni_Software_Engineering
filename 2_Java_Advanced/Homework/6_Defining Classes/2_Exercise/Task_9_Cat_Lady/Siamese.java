public class Siamese {

    private final String breed;
    private final double earSize;

    public Siamese(double earSize) {
        this.breed = "Siamese";
        this.earSize = earSize;
    }

    public String getEarSize() {
        return String.format("%.2f", earSize);
    }
    public String getBreed() {
        return breed;
    }
}