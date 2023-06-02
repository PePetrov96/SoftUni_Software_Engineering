package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerCreateFromJsonDTO implements Serializable {
    @Expose
    private String name;
    @Expose
    private String birthDate;
    @Expose
    private boolean isYoungDriver;
    @Expose
    private List<SaleCreateFromJsonDTO> sales = new ArrayList<>();

    public CustomerCreateFromJsonDTO() {
    }

    public CustomerCreateFromJsonDTO(String name, String birthDate, boolean isYoungDriver) {
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
        this.sales = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<SaleCreateFromJsonDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleCreateFromJsonDTO> sales) {
        this.sales = sales;
    }
}
