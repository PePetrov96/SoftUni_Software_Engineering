package com.example.jsonprocessing.model.DTOs;

import java.math.BigDecimal;

public class ProductUserJsonDto {
    private String name;
    private BigDecimal price;

    public ProductUserJsonDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
