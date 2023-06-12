package com.example.xmlprocessing.DTOs.ExportDTOs.User;

import com.example.xmlprocessing.DTOs.ExportDTOs.Product.SoldProductDTO;
import com.example.xmlprocessing.DTOs.ExportDTOs.Product.SoldProductWrapper;
import com.example.xmlprocessing.model.Product;
import jakarta.xml.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersProductsExportDTO {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private int age;
    @XmlElement(name = "sold-products")
    private SoldProductWrapper productWrapper;

    private int productCount;

    public UsersProductsExportDTO(String firstName, String lastName, int age, List<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.productWrapper = productWrapper(products);
        this.productCount = products.size();
    }

    private SoldProductWrapper productWrapper(List<Product> products) {
        return new SoldProductWrapper(
                products.stream().map(this::productDTO)
                        .collect(Collectors.toList())
        );
    }

    private SoldProductDTO productDTO(Product product) {
        return new SoldProductDTO(product.getName(), product.getPrice());
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public UsersProductsExportDTO() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductWrapper getProductWrapper() {
        return productWrapper;
    }

    public void setProductWrapper(SoldProductWrapper productWrapper) {
        this.productWrapper = productWrapper;
    }
}
