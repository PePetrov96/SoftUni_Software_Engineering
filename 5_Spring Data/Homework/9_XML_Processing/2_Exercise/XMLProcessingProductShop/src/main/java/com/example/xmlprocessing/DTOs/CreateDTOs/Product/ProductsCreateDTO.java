package com.example.xmlprocessing.DTOs.CreateDTOs.Product;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsCreateDTO implements Serializable {
    @XmlElement(name = "product")
    private List<ProductCreateDTO> productCreateDTOs;

    public ProductsCreateDTO() {

        this.productCreateDTOs = new ArrayList<>();
    }

    public List<ProductCreateDTO> getProductCreateDTOs() {
        return productCreateDTOs;
    }

    public void setProductCreateDTOs(List<ProductCreateDTO> productCreateDTOs) {
        this.productCreateDTOs = productCreateDTOs;
    }
}
