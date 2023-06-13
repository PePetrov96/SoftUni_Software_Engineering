package com.example.project.DTOs.ExportDTOs.Cars;

import com.example.project.DTOs.ExportDTOs.Parts.PartExportDTO;
import com.example.project.DTOs.ExportDTOs.Parts.Wrappers.PartExportWrapper;
import com.example.project.model.Part;
import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsExportDTO {
    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private BigInteger travelledDistance;
    @XmlElement(name = "parts")
    private PartExportWrapper parts;

    public CarWithPartsExportDTO(String make, String model, BigInteger travelledDistance, List<Part> parts) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.parts = new PartExportWrapper(
                parts.stream()
                        .map(part ->  new PartExportDTO(
                                part.getName(),
                                part.getPrice()
                        ))
                        .toList());
    }

    public CarWithPartsExportDTO() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigInteger getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public PartExportWrapper getParts() {
        return parts;
    }

    public void setParts(PartExportWrapper parts) {
        this.parts = parts;
    }
}
