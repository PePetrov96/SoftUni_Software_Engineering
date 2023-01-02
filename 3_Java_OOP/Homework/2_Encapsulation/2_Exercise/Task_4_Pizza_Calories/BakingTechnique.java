package Task_4_Pizza_Calories;

public enum BakingTechnique {
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    private final double value;

    BakingTechnique(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
