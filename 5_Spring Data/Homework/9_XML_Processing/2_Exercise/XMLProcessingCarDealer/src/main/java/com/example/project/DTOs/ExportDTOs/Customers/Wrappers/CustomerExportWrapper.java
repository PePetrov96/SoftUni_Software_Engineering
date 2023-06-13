package com.example.project.DTOs.ExportDTOs.Customers.Wrappers;

import com.example.project.DTOs.ExportDTOs.Customers.CustomerExportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerExportWrapper {
    @XmlElement(name = "customer")
    private List<CustomerExportDTO> customerDTOs;

    public CustomerExportWrapper(List<CustomerExportDTO> customerDTOs) {
        this.customerDTOs = customerDTOs;
    }

    public CustomerExportWrapper() {
    }

    public List<CustomerExportDTO> getCustomerDTOs() {
        return customerDTOs;
    }

    public void setCustomerDTOs(List<CustomerExportDTO> customerDTOs) {
        this.customerDTOs = customerDTOs;
    }
}
