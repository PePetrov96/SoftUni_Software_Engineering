package com.example.project.DTOs.ExportDTOs.Customers;

import com.example.project.model.Car;
import com.example.project.model.Part;
import com.example.project.model.Sale;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerSalesDTO {
    @XmlAttribute(name = "full-name")
    private String fullName;
    @XmlAttribute(name = "bought-cars")
    private long boughtCars;
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public CustomerSalesDTO(String fullName, List<Sale> sales) {
        List<Car> cars = sales.stream()
                .map(Sale::getCar)
                .toList();

        this.fullName = fullName;
        this.boughtCars = cars.size();
        this.spentMoney = cars.stream()
                .flatMap(car -> car.getParts().stream())
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public CustomerSalesDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(long boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
