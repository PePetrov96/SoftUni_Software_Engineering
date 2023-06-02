package com.example.jsonprocessing.model.DTOs;

import com.example.jsonprocessing.model.Customer;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleJsonExportDTO implements Serializable {
    @Expose
    private Long id;
    @Expose
    private CarJsonExportDTO car;
    @Expose
    private CustomerJsonExportDTO customer;
    @Expose
    private String customerName;
    @Expose
    private BigDecimal discount;
    @Expose
    private BigDecimal price;
    @Expose
    private BigDecimal priceWithDiscount;

    public SaleJsonExportDTO() {
    }

    public SaleJsonExportDTO(CarJsonExportDTO car, CustomerJsonExportDTO customer, BigDecimal discount) {
        this.car = car;
        this.customer = customer;
        this.discount = discount;
    }

    public SaleJsonExportDTO(Customer customer, BigDecimal discount, BigDecimal price) {
        this.customerName = customer.getName();

        BigDecimal fullDiscount = discount;

        if (customer.isYoungDriver()) {
            fullDiscount = discount.add(BigDecimal.valueOf(5));
        }

        this.discount = fullDiscount;

        this.price = price;

        this.priceWithDiscount = price.subtract(
                price.multiply(
                        fullDiscount.divide(
                                BigDecimal.valueOf(100))));
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarJsonExportDTO getCar() {
        return car;
    }

    public void setCar(CarJsonExportDTO car) {
        this.car = car;
    }

    public CustomerJsonExportDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerJsonExportDTO customer) {
        this.customer = customer;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
