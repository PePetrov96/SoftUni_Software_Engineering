package com.example.xmlprocessing.DTOs.ExportDTOs.Product;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductWrapper {
    @XmlAttribute(name = "count")
    private int count;
    @XmlElement(name = "product")
    private List<SoldProductDTO> products;

    public SoldProductWrapper(List<SoldProductDTO> products) {
        this.count = products.size();
        this.products = products;
    }

    public SoldProductWrapper() {
    }

    public SoldProductWrapper(int count, List<SoldProductDTO> products) {
        this.count = count;
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SoldProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<SoldProductDTO> products) {
        this.products = products;
    }
}
