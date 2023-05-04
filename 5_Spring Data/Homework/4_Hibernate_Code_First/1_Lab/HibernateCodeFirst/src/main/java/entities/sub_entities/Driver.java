package entities.sub_entities;

import entities.Car;
import entities.Truck;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(mappedBy = "drivers")
    private Set<Car> cars = new HashSet<>();

    @ManyToMany(mappedBy = "drivers")
    private Set<Truck> trucks = new HashSet<>();

    public Driver() {}

    public Driver(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(Set<Truck> trucks) {
        this.trucks = trucks;
    }

    public void addCar(Car car) {
        cars.add(car);
        car.getDrivers().add(this);
    }

    public void removeCar(Car car) {
        cars.remove(car);
        car.getDrivers().remove(this);
    }

    public void addTruck(Truck truck) {
        trucks.add(truck);
        truck.getDrivers().add(this);
    }

    public void removeTruck(Truck truck) {
        trucks.remove(truck);
        truck.getDrivers().remove(this);
    }
}
