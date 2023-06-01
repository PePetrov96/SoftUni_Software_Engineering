package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private List<ProductDto> soldProducts = new ArrayList<>();
    @Expose
    private List<ProductDto> boughtProducts = new ArrayList<>();
    @Expose
    private List<UserDto> friends = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<ProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public List<ProductDto> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<ProductDto> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public List<UserDto> getFriends() {
        return friends;
    }

    public void setFriends(List<UserDto> friends) {
        this.friends = friends;
    }
}