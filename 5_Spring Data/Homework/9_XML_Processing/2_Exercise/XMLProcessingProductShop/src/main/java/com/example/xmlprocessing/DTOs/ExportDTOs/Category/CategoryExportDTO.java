package com.example.xmlprocessing.DTOs.ExportDTOs.Category;

import com.example.xmlprocessing.model.Product;
import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryExportDTO {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "products-count")
    private long productCount;
    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public CategoryExportDTO(String name, List<Product> products) {
        this.name = name;

        this.productCount = products.size();

        this.averagePrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP);

        this.totalRevenue = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public CategoryExportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
