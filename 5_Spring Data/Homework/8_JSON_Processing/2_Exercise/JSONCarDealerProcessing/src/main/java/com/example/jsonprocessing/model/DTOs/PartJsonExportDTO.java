package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PartJsonExportDTO {
    @Expose
    private Long Id;
    @Expose
    private String Name;
    @Expose
    private BigDecimal Price;
    @Expose
    private int Quantity;
    @Expose
    private SupplierJsonExportDTO Supplier;
    @Expose
    private List<CarJsonExportDTO> Cars;

    public PartJsonExportDTO() {
    }

    public PartJsonExportDTO(String name, BigDecimal price, int quantity, SupplierJsonExportDTO supplier) {
        this.Name = name;
        this.Price = price;
        this.Quantity = quantity;
        this.Supplier = supplier;
        this.Cars = new ArrayList<>();
    }

    public PartJsonExportDTO(String name, BigDecimal price) {
        this.Name = name;
        this.Price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        this.Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public SupplierJsonExportDTO getSupplier() {
        return Supplier;
    }

    public void setSupplier(SupplierJsonExportDTO supplier) {
        this.Supplier = supplier;
        supplier.addPart(this);
    }

    public List<CarJsonExportDTO> getCars() {
        return Cars;
    }

    public void setCars(List<CarJsonExportDTO> cars) {
        this.Cars = cars;
    }

    public void addCar(CarJsonExportDTO car) {
        this.Cars.add(car);
    }

    public void removeCar(CarJsonExportDTO car) {
        this.Cars.remove(car);
    }
}
