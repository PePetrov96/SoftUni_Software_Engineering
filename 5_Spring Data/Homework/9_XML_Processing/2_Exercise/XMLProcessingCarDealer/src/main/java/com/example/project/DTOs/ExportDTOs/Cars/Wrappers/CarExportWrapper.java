package com.example.project.DTOs.ExportDTOs.Cars.Wrappers;

import com.example.project.DTOs.ExportDTOs.Cars.CarExportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarExportWrapper {
    @XmlElement(name = "car")
    private List<CarExportDTO> cars;

    public CarExportWrapper(List<CarExportDTO> cars) {
        this.cars = cars;
    }

    public CarExportWrapper() {
    }

    public List<CarExportDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarExportDTO> cars) {
        this.cars = cars;
    }
}
