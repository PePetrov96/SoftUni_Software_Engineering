package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDto implements Serializable {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private UserDto seller;
    @Expose
    private UserDto buyer;
    @Expose
    private List<CategoryDto> categories = new ArrayList<>();
    public ProductDto() {
    }
    public ProductDto(String name, double price, UserDto seller, UserDto buyer) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.buyer = buyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public UserDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
}
