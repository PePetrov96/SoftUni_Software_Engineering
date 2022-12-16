public class Car {
    String carModel;
    Engine engine;
    String weight;
    String color;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return String.format(
                "%s:%n" +
                        "%s%n" +
                        "Weight: %s%n" +
                        "Color: %s"
                ,this.carModel, this.engine, this.weight, this.color);
    }
}