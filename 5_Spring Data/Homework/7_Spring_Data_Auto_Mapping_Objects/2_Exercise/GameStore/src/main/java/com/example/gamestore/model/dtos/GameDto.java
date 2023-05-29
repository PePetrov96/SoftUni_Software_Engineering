package com.example.gamestore.model.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDto {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameDto(String title, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public GameDto() {
    }

    @Override
    public String toString() {
        return String.format("""
                Title: %s
                Price: %.2f
                Description: %s
                Release date: %s""", title, price, description, releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}