package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO implements Serializable {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private UserDTO seller;
    @Expose
    private UserDTO buyer;
    @Expose
    private List<CategoryDTO> categories = new ArrayList<>();
    public ProductDTO() {
    }
    public ProductDTO(String name, double price, UserDTO seller, UserDTO buyer) {
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

    public UserDTO getSeller() {
        return seller;
    }

    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    public UserDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDTO buyer) {
        this.buyer = buyer;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
