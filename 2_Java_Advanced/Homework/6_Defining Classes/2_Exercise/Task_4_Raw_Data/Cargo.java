public class Cargo {
    int cargoWeight;
    String cargoType;

    public Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }
    public boolean isFragile() {
        return cargoType.equals("fragile");
    }
}