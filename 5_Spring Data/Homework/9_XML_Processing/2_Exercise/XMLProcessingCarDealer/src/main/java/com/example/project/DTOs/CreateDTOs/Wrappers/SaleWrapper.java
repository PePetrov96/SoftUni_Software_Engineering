package com.example.project.DTOs.CreateDTOs.Wrappers;

import com.example.project.DTOs.CreateDTOs.SaleDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWrapper {
    @XmlElement(name = "sale")
    private List<SaleDTO> sales;

    public SaleWrapper(List<SaleDTO> sales) {
        this.sales = sales;
    }

    public SaleWrapper() {
    }

    public List<SaleDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleDTO> sales) {
        this.sales = sales;
    }
}
