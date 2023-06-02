package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private List<ProductDTO> soldProducts = new ArrayList<>();
    @Expose
    private List<ProductDTO> boughtProducts = new ArrayList<>();
    @Expose
    private List<UserDTO> friends = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, Integer age) {
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

    public List<ProductDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public List<ProductDTO> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<ProductDTO> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public List<UserDTO> getFriends() {
        return friends;
    }

    public void setFriends(List<UserDTO> friends) {
        this.friends = friends;
    }
}