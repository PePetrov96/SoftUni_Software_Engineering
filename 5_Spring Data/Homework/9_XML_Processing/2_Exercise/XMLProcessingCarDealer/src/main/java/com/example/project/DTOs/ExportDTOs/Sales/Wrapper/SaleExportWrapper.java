package com.example.project.DTOs.ExportDTOs.Sales.Wrapper;

import com.example.project.DTOs.ExportDTOs.Sales.SaleExportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleExportWrapper {
    @XmlElement(name = "sale")
    private List<SaleExportDTO> sales;

    public SaleExportWrapper(List<SaleExportDTO> sales) {
        this.sales = sales;
    }

    public SaleExportWrapper() {
    }

    public List<SaleExportDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleExportDTO> sales) {
        this.sales = sales;
    }
}
