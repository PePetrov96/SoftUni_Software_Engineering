package com.example.project.DTOs.ExportDTOs.Customers.Wrappers;

import com.example.project.DTOs.ExportDTOs.Customers.CustomerSalesDTO;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSalesWrapper {
    @XmlElement(name = "customer")
    private List<CustomerSalesDTO> customers;

    public CustomerSalesWrapper(List<CustomerSalesDTO> customers) {
        this.customers = customers;
    }

    public CustomerSalesWrapper() {
    }

    public List<CustomerSalesDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerSalesDTO> customers) {
        this.customers = customers;
    }
}
