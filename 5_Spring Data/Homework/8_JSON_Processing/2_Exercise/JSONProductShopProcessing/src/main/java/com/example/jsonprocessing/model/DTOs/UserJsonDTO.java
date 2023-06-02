package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserJsonDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductWithBuyerJsonDTO> soldProducts = new ArrayList<>();

    public UserJsonDTO(String firstName, String lastName, List<ProductWithBuyerJsonDTO> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }

    public UserJsonDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductWithBuyerJsonDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductWithBuyerJsonDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
