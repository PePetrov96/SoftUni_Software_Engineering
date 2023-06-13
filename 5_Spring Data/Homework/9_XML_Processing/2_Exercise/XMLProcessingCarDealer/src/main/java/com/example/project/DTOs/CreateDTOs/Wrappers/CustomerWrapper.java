package com.example.project.DTOs.CreateDTOs.Wrappers;

import com.example.project.DTOs.CreateDTOs.CustomerDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWrapper {
    @XmlElement(name = "customer")
    private List<CustomerDTO> customers;

    public CustomerWrapper(List<CustomerDTO> customers) {
        this.customers = customers;
    }

    public CustomerWrapper() {
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTO> customers) {
        this.customers = customers;
    }
}
