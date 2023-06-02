package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SupplierJsonExportDTO implements Serializable {
    @Expose
    private Long Id;
    @Expose
    private String Name;
    @Expose
    private boolean IsImporter;
    @Expose
    private int partsCount;
    @Expose
    private List<PartJsonExportDTO> Parts;

    public SupplierJsonExportDTO() {
    }

    public SupplierJsonExportDTO(String name, boolean isImporter) {
        this.Name = name;
        this.IsImporter = isImporter;
        this.Parts = new ArrayList<>();
    }

    public SupplierJsonExportDTO(Long id, String name, int partsCount) {
        this.Id = id;
        this.Name = name;
        this.partsCount = partsCount;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public boolean isImporter() {
        return IsImporter;
    }

    public void setImporter(boolean importer) {
        IsImporter = importer;
    }

    public List<PartJsonExportDTO> getParts() {
        return Parts;
    }

    public void setParts(List<PartJsonExportDTO> parts) {
        this.Parts = parts;
    }

    public void addPart(PartJsonExportDTO part) {
        this.Parts.add(part);
    }

    public void removePart(PartJsonExportDTO part) {
        this.Parts.remove(part);
    }
}
