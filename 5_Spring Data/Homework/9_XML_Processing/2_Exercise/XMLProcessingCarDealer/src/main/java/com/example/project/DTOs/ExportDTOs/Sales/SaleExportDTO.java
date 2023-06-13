package com.example.project.DTOs.ExportDTOs.Sales;

import com.example.project.DTOs.ExportDTOs.Cars.CarSaleExportDTO;
import com.example.project.model.Car;
import com.example.project.model.Part;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;

@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleExportDTO {
    @XmlElement(name = "car")
    private CarSaleExportDTO car;
    @XmlElement(name = "customer-name")
    private String name;
    @XmlElement(name = "discount")
    private BigDecimal discount;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleExportDTO(Car car, String name, BigDecimal discount) {
        this.car = new CarSaleExportDTO(
                car.getMake(),
                car.getModel(),
                car.getTravelledDistance());

        this.name = name;

        this.discount = discount;

        this.price = car.getParts()
                .stream()
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.priceWithDiscount = price.subtract(
                price.multiply(discount).divide(new BigDecimal(100)));
    }

    public SaleExportDTO() {
    }

    public CarSaleExportDTO getCar() {
        return car;
    }

    public void setCar(CarSaleExportDTO car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
