public class Engine {
    String engineModel;
    int enginePower;
    String engineDisplacement;
    String engineEfficiency;

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = "n/a";
        this.engineEfficiency = "n/a";
    }
    @Override
    public String toString() {
        return String.format(
                "%s:%n" +
                        "Power: %d%n" +
                        "Displacement: %s%n" +
                        "Efficiency: %s"
                ,this.engineModel, this.enginePower
                ,this.engineDisplacement, this.engineEfficiency);
    }
}