package com.example.project.DTOs.CreateDTOs.Wrappers;

import com.example.project.DTOs.CreateDTOs.SupplierDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierWrapper {
    @XmlElement(name = "supplier")
    private List<SupplierDTO> suppliers;

    public SupplierWrapper(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public SupplierWrapper() {
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }
}
