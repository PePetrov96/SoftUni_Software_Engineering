package Task_4_Need_For_Speed;

public class Vehicle {
    private final double DEFAULT_FUEL_CONSUMPTION = 1.25;
    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }

    public void drive(double kilometers) {
        double needed = kilometers * this.fuelConsumption;
        if (this.fuel >= needed) {
            setFuel(this.fuel - needed);
        }
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setFuel(double fuel) {
        this.fuel = fuel;
    }

    private void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    private double getDEFAULT_FUEL_CONSUMPTION() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }
}