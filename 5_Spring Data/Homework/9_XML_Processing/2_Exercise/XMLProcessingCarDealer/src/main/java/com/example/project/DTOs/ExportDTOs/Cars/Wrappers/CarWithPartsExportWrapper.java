package com.example.project.DTOs.ExportDTOs.Cars.Wrappers;

import com.example.project.DTOs.ExportDTOs.Cars.CarWithPartsExportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsExportWrapper {
    @XmlElement(name = "car")
    private List<CarWithPartsExportDTO> cars;

    public CarWithPartsExportWrapper(List<CarWithPartsExportDTO> cars) {
        this.cars = cars;
    }

    public CarWithPartsExportWrapper() {
    }

    public List<CarWithPartsExportDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarWithPartsExportDTO> cars) {
        this.cars = cars;
    }
}
