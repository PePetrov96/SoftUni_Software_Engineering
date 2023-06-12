package com.example.xmlprocessing.DTOs.ExportDTOs.Product;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductExportWrapper {
    @XmlElement(name = "product")
    private List<ProductExportDTO> productExportDTOs;

    public ProductExportWrapper() {
    }

    public ProductExportWrapper(List<ProductExportDTO> productExportDTOs) {
        this.productExportDTOs = productExportDTOs;
    }

    public List<ProductExportDTO> getProductExportDTOs() {
        return productExportDTOs;
    }

    public void setProductExportDTOs(List<ProductExportDTO> productExportDTOs) {
        this.productExportDTOs = productExportDTOs;
    }
}
