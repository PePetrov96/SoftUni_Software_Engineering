package com.example.jsonprocessing.model.DTOs;

import com.example.jsonprocessing.config.LocalDateSerializer;
import com.example.jsonprocessing.model.Part;
import com.example.jsonprocessing.model.Sale;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerJsonExportDTO {
    @Expose
    private Long Id;
    @Expose
    private String Name;
    @Expose
    @JsonAdapter(LocalDateSerializer.class)
    private LocalDate BirthDate;
    @Expose
    private boolean IsYoungDriver;
    @Expose
    private List<SaleJsonExportDTO> Sales;
    @Expose
    private String fullName;
    @Expose
    private int boughtCars;
    @Expose
    private BigDecimal spentMoney;

    public CustomerJsonExportDTO() {
    }

    public CustomerJsonExportDTO(Long id, String name, LocalDate birthDate, boolean isYoungDriver) {
        this.Id = id;
        this.Name = name;
        this.BirthDate = birthDate;
        this.IsYoungDriver = isYoungDriver;
        this.Sales = new ArrayList<>();
    }

    public CustomerJsonExportDTO(String fullName, List<Sale> sales) {
        this.fullName = fullName;
        this.boughtCars = sales.size();
        this.spentMoney = sales.stream()
                .map(Sale::getCar)
                .flatMap(car -> car.getParts().stream())
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
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

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.BirthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return IsYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        IsYoungDriver = youngDriver;
    }

    public List<SaleJsonExportDTO> getSales() {
        return Sales;
    }

    public void setSales(List<SaleJsonExportDTO> sales) {
        this.Sales = sales;
    }
}
