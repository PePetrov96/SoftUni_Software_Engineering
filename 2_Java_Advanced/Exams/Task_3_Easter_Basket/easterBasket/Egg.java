package easterBasket;

public class Egg {
    private String color;
    private int strength;
    private String shape;

    public Egg(String color, int strength, String shape) {
        this.setColor(color);
        this.setStrength(strength);
        this.setShape(shape);
    }

    @Override
    public String toString() {
        return String.format("%s egg, with %d strength and %s shape.", this.color, this.strength, this.shape);
    }

    public String getColor() {
        return color;
    }

    public int getStrength() {
        return strength;
    }

    public String getShape() {
        return shape;
    }

    private void setColor(String color) {
        this.color = color;
    }

    private void setStrength(int strength) {
        this.strength = strength;
    }

    private void setShape(String shape) {
        this.shape = shape;
    }
}