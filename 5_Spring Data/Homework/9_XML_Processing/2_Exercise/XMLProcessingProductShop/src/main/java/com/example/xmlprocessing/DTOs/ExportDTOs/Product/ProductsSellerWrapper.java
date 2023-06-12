package com.example.xmlprocessing.DTOs.ExportDTOs.Product;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSellerWrapper {
    @XmlElement(name = "product")
    private List<ProductsSellerDTO> products;

    public ProductsSellerWrapper(List<ProductsSellerDTO> products) {
        this.products = products;
    }

    public ProductsSellerWrapper() {
    }

    public List<ProductsSellerDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsSellerDTO> products) {
        this.products = products;
    }
}
