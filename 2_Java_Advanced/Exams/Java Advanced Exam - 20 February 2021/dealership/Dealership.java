package dealership;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Dealership {
    Collection<Car> data;
    String name;
    int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (getCount() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        return this.data.remove(getCar(manufacturer, model));
    }

    public Car getLatestCar(){
        return this.data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return this.data.stream()
                .filter(car1 -> car1.getManufacturer().equals(manufacturer) &&
                        car1.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder out = new StringBuilder(
                String.format(" The cars are in a car dealership %s:", this.name))
                .append(System.lineSeparator());

        for (Car car:this.data) {
            out.append(car.toString())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}