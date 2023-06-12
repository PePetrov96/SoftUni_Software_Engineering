package com.example.xmlprocessing.DTOs.CreateDTOs.Product;

import com.example.xmlprocessing.DTOs.CreateDTOs.Category.CategoryCreateDTO;
import com.example.xmlprocessing.DTOs.CreateDTOs.User.UserCreateDTO;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductCreateDTO implements Serializable {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "price")
    private double price;
    @XmlElement(name = "seller")
    private UserCreateDTO seller;
    @XmlElement(name = "buyer")
    private UserCreateDTO buyer;
    @XmlElement(name = "category")
    private CategoryCreateDTO category;

    public ProductCreateDTO(String name, double price, UserCreateDTO seller, UserCreateDTO buyer, CategoryCreateDTO category) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.buyer = buyer;
        this.category = category;
    }

    public ProductCreateDTO() {
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

    public UserCreateDTO getSeller() {
        return seller;
    }

    public void setSeller(UserCreateDTO seller) {
        this.seller = seller;
    }

    public UserCreateDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(UserCreateDTO buyer) {
        this.buyer = buyer;
    }

    public CategoryCreateDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryCreateDTO category) {
        this.category = category;
    }
}
