package Task_1_Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;

    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    protected void drive(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");

        double needed = distance * this.fuelConsumption;

        if (this.fuelQuantity >= needed) {
            fuelQuantity -= needed;
            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), df.format(distance));
        } else {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        }
    }

    protected void refuel(double fuel) {
        this.fuelQuantity += fuel;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public final double getFuelQuantity() {
        return fuelQuantity;
    }

    public final double getFuelConsumption() {
        return fuelConsumption;
    }
}