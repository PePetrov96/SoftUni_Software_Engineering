package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.util.List;

public class CarPartWrapperJsonExportDTO {
    @Expose
    private CarJsonExportDTO car;
    @Expose
    private List<PartJsonExportDTO> parts;

    public CarPartWrapperJsonExportDTO(CarJsonExportDTO car, List<PartJsonExportDTO> parts) {
        this.car = car;
        this.parts = parts;
    }

    public CarJsonExportDTO getCar() {
        return car;
    }

    public void setCar(CarJsonExportDTO car) {
        this.car = car;
    }

    public List<PartJsonExportDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartJsonExportDTO> parts) {
        this.parts = parts;
    }
}