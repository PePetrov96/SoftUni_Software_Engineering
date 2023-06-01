package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserJsonDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductWithBuyerJsonDto> soldProducts = new ArrayList<>();

    public UserJsonDto(String firstName, String lastName, List<ProductWithBuyerJsonDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }

    public UserJsonDto() {
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

    public List<ProductWithBuyerJsonDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductWithBuyerJsonDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
