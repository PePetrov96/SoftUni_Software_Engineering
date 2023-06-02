package com.example.jsonprocessing.model.DTOs;

import com.example.jsonprocessing.model.Part;
import com.example.jsonprocessing.model.Sale;
import com.google.gson.annotations.Expose;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class CarJsonExportDTO {
    @Expose
    private Long Id;
    @Expose
    private String Make;
    @Expose
    private String Model;
    @Expose
    private BigInteger TravelledDistance;
    @Expose
    private List<PartJsonExportDTO> Parts;
    @Expose
    private SaleJsonExportDTO Sale;

    private ModelMapper mapper = new ModelMapper();

    public CarJsonExportDTO() {
    }

    public CarJsonExportDTO(String make, String model, BigInteger travelledDistance) {
        this.Make = make;
        this.Model = model;
        this.TravelledDistance = travelledDistance;
    }

    public CarJsonExportDTO(Long id, String make, String model, BigInteger travelledDistance) {
        this.Id = id;
        this.Make = make;
        this.Model = model;
        this.TravelledDistance = travelledDistance;
    }

    public CarJsonExportDTO(String make, String model, BigInteger travelledDistance, Sale sale) {
        this.Make = make;
        this.Model = model;
        this.TravelledDistance = travelledDistance;

        BigDecimal priceTag = sale.getCar()
                .getParts()
                .stream()
                .map(Part::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        this.Sale = new SaleJsonExportDTO(sale.getCustomer(), sale.getDiscount(), priceTag);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        this.Make = make;
    }


    public String getModel() {
        return Model;
    }


    public void setModel(String model) {
        this.Model = model;
    }

    public BigInteger getTravelledDistance() {
        return TravelledDistance;
    }

    public void setTravelledDistance(BigInteger travelledDistance) {
        this.TravelledDistance = travelledDistance;
    }

    public List<PartJsonExportDTO> getParts() {
        return Parts;
    }

    public void setParts(List<PartJsonExportDTO> parts) {
        this.Parts = parts;
    }

    public SaleJsonExportDTO getSale() {
        return Sale;
    }

    public void setSale(SaleJsonExportDTO sale) {
        this.Sale = sale;
    }

    public void addPart(PartJsonExportDTO part) {
        this.Parts.add(part);
        part.addCar(this);
    }

    public void removePart(PartJsonExportDTO part) {
        this.Parts.remove(part);
        part.removeCar(this);
    }
}
