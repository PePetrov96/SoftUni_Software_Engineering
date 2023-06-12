package com.example.xmlprocessing.DTOs.ExportDTOs.User;

import com.example.xmlprocessing.DTOs.ExportDTOs.Product.ProductsSellerWrapper;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserExportDTO {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlElement(name = "sold-products")
    private ProductsSellerWrapper soldProducts;

    public UserExportDTO(String firstName, String lastName, ProductsSellerWrapper soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.soldProducts = soldProducts;
    }

    public UserExportDTO() {
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

    public ProductsSellerWrapper getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsSellerWrapper soldProducts) {
        this.soldProducts = soldProducts;
    }
}
