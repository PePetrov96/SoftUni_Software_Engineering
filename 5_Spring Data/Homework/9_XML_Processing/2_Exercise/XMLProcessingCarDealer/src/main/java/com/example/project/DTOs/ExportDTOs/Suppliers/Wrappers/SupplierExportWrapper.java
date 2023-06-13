package com.example.project.DTOs.ExportDTOs.Suppliers.Wrappers;

import com.example.project.DTOs.ExportDTOs.Suppliers.SupplierExportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierExportWrapper {
    @XmlElement(name = "supplier")
    private List<SupplierExportDTO> suppliers;

    public SupplierExportWrapper(List<SupplierExportDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public SupplierExportWrapper() {
    }

    public List<SupplierExportDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierExportDTO> suppliers) {
        this.suppliers = suppliers;
    }
}
