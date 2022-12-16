public class Car {
    String name;
    double fuel;
    double fuelPerKm;
    int distanceTraveled;

    public Car(String name, double fuel, double fuelPerKm) {
        this.name = name;
        this.fuel = fuel;
        this.fuelPerKm = fuelPerKm;
        this.distanceTraveled = 0;
    }

    public boolean itCanMove (int distance) {
        double required = distance * getFuelPerKm();
        return required <= getFuel();
    }

    public void driveIt (int distance) {
        setDistanceTraveled(getDistanceTraveled() + distance);
        setFuel(getFuel() - (distance * fuelPerKm));
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.name, getFuel(), getDistanceTraveled());
    }
}