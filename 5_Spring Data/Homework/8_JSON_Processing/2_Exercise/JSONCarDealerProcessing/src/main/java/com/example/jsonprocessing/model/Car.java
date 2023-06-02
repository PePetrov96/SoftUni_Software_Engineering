package com.example.jsonprocessing.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "travelled_distance")
    private BigInteger travelledDistance;

    @ManyToMany
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id"))
    private List<Part> parts = new ArrayList<>();

    @OneToOne(mappedBy = "car")
    private Sale sale;

    public Car() {
    }

    public Car(String make, String model, BigInteger travelledDistance) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public void addPart(Part part) {
        this.parts.add(part);;
        part.addCar(this);
    }

    public void removePart(Part part) {
        this.parts.remove(part);
        part.removeCar(this);
    }

}