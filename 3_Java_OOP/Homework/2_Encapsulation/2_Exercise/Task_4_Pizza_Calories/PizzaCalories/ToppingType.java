package PizzaCalories;

public enum ToppingType {
    Meat(1.2),
    Veggies(0.8),
    Cheese(1.1),
    Sauce(0.9);

    private final double value;

    ToppingType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}