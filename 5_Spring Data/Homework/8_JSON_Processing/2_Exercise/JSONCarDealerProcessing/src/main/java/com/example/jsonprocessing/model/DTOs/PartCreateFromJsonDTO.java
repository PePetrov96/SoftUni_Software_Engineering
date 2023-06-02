package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PartCreateFromJsonDTO implements Serializable {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;
    @Expose
    private SupplierCreateFromJsonDTO supplier;
    @Expose
    private List<CarCreateFromJsonDTO> cars = new ArrayList<>();

    public PartCreateFromJsonDTO() {
    }

    public PartCreateFromJsonDTO(String name, BigDecimal price, int quantity, SupplierCreateFromJsonDTO supplier) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SupplierCreateFromJsonDTO getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierCreateFromJsonDTO supplier) {
        this.supplier = supplier;
        supplier.addPart(this);
    }

    public List<CarCreateFromJsonDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarCreateFromJsonDTO> cars) {
        this.cars = cars;
    }

    public void addCar(CarCreateFromJsonDTO car) {
        this.cars.add(car);
    }

    public void removeCar(CarCreateFromJsonDTO car) {
        this.cars.remove(car);
    }
}
