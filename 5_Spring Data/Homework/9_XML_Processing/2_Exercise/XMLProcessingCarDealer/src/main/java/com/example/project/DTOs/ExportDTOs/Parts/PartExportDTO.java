package com.example.project.DTOs.ExportDTOs.Parts;

import jakarta.xml.bind.annotation.*;

import java.math.BigDecimal;

@XmlRootElement(name = "part")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartExportDTO {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "price")
    private BigDecimal price;

    public PartExportDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public PartExportDTO() {
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
