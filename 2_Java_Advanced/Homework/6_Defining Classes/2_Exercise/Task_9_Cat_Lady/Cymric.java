public class Cymric {
    private final String breed;
    private final double furLength;

    public Cymric(double furLength) {
        this.breed = "Cymric";
        this.furLength = furLength;
    }

    public String getFurLength() {
        return String.format("%.2f", furLength);
    }
    public String getBreed() {
        return breed;
    }
}