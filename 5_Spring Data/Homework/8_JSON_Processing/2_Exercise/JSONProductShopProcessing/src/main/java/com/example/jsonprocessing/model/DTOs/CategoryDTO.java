package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDTO implements Serializable {
    @Expose
    private String name;
    @Expose
    private List<ProductDTO> products = new ArrayList<>();

    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
