package entities;

import entities.sub_entities.Company;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "planes")
public class Plane extends Vehicle{
    private static final String type = "PLANE";
    private int passengerCapacity;
    private String airline;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Plane() {
        super(type);
    }

    public Plane(String model, BigDecimal price, String fuelType, int passengerCapacity, String airline) {
        this();

        super.setModel(model);
        super.setFuelType(fuelType);
        super.setPrice(price);
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}