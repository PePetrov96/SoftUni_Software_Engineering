package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleCreateFromJsonDTO implements Serializable {
    @Expose
    private CarCreateFromJsonDTO car;
    @Expose
    private CustomerCreateFromJsonDTO customer;
    @Expose
    private BigDecimal discount;

    public SaleCreateFromJsonDTO() {
    }

    public SaleCreateFromJsonDTO(CarCreateFromJsonDTO car, CustomerCreateFromJsonDTO customer, BigDecimal discount) {
        this.car = car;
        this.customer = customer;
        this.discount = discount;
    }

    public CarCreateFromJsonDTO getCar() {
        return car;
    }

    public void setCar(CarCreateFromJsonDTO car) {
        this.car = car;
    }

    public CustomerCreateFromJsonDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerCreateFromJsonDTO customer) {
        this.customer = customer;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
