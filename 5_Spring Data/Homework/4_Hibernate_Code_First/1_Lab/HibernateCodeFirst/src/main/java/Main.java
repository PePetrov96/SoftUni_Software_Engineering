import entities.*;
import entities.sub_entities.Company;
import entities.sub_entities.Driver;
import entities.sub_entities.PlateNumber;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("relations_schema");
    private static final EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        em.getTransaction().begin();

        // add a bunch of entities with values
        Car car = new Car("Ford", new BigDecimal("20000"), "Gas", 5, null);
        Bike bike = new Bike("BMW", new BigDecimal("500"), "will power");
        Truck truck = new Truck("Seat", new BigDecimal("300000"), "Diesel", 1000);
        Plane airplane = new Plane("AirBus", new BigDecimal("1000000000"), "jet fuel", 350, "Bulgaria Air");

        em.persist(car);
        em.persist(bike);
        em.persist(truck);
        em.persist(airplane);


        // add a bunch of entities with no values (since we've allowed null values)
        Car car2 = new Car();
        Bike bike2 = new Bike();
        Truck truck2 = new Truck();
        Plane airplane2 = new Plane();

        em.persist(car2);
        em.persist(bike2);
        em.persist(truck2);
        em.persist(airplane2);


        // add a Car with PlateNumber
        PlateNumber plate = new PlateNumber("CA 1234 BA");
        car.setPlateNumber(plate);

        em.merge(car);

        PlateNumber plate2 = new PlateNumber("CA 5678 DE");
        Vehicle car3 = new Car("Mercedes", new BigDecimal("100000"), "Gas", 4, plate2);

        em.persist(car3);


        // add a Plane with a Company
        Company company = new Company("Bulgaria Air");
        em.persist(company);

        airplane.setCompany(company);
        em.merge(airplane);

        company.addPlane(airplane2);

        //add Driver to Car
        Driver driver1 = new Driver("Ivan Ivanov");
        Driver driver2 = new Driver("Petar Petrov");

        em.persist(driver1);
        em.persist(driver2);

        driver1.addCar(car);
        driver1.addTruck(truck);
        driver1.addCar(car2);

        driver2.addCar(car);
        driver2.addTruck(truck);

        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}