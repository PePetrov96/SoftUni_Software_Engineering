package com.example.jsonprocessing.model.DTOs;

import com.example.jsonprocessing.model.Sale;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CarCreateFromJsonDTO implements Serializable {
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private BigInteger travelledDistance;
    @Expose
    private List<PartCreateFromJsonDTO> parts = new ArrayList<>();
    @Expose
    private Sale sale;

    public CarCreateFromJsonDTO() {
    }
    public CarCreateFromJsonDTO(String make, String model, BigInteger travelledDistance, Sale sale) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.parts = new ArrayList<>();
        this.sale = sale;
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

    public List<PartCreateFromJsonDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartCreateFromJsonDTO> parts) {
        this.parts = parts;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public void addPart(PartCreateFromJsonDTO part) {
        this.parts.add(part);
        part.addCar(this);
    }

    public void removePart(PartCreateFromJsonDTO part) {
        this.parts.remove(part);
        part.removeCar(this);
    }
}
