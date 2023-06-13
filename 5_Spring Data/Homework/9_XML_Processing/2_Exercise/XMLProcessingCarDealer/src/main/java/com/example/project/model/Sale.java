package com.example.project.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "discount")
    private BigDecimal discount;

    public Sale() {
    }

    public Sale(Car car, Customer customer, BigDecimal discount) {
        this.car = car;
        this.customer = customer;
        this.discount = discount;
    }

//    @PrePersist
//    public void applyAdditionalDiscount() {
//        if (customer != null && customer.isYoungDriver()) {
//            discount = discount.add(BigDecimal.valueOf(5));
//        }
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
        car.setSale(this);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.addSale(this);
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}