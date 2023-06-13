package com.example.project.DTOs.CreateDTOs.Wrappers;

import com.example.project.DTOs.CreateDTOs.CarDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWrapper {
    @XmlElement(name = "car")
    private List<CarDTO> cars;

    public CarWrapper(List<CarDTO> cars) {
        this.cars = cars;
    }

    public CarWrapper() {
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }
}
