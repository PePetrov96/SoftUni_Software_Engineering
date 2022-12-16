package PII;

public class Car {
    private String carModel;
    private int carSpeed;

    @Override
    public String toString() {
        return String.format("%s %d", this.carModel, this.carSpeed);
    }

    public void updateCar (String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = Integer.parseInt(carSpeed);
    }

    public String getCarModel() {
        return carModel;
    }
}