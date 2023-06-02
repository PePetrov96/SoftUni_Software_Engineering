package com.example.jsonprocessing.model.DTOs;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SupplierCreateFromJsonDTO implements Serializable {
    @Expose
    private String name;
    @Expose
    private boolean isImporter;
    @Expose
    private List<PartCreateFromJsonDTO> parts = new ArrayList<>();

    public SupplierCreateFromJsonDTO() {
    }

    public SupplierCreateFromJsonDTO(String name, boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
        this.parts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public List<PartCreateFromJsonDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartCreateFromJsonDTO> parts) {
        this.parts = parts;
    }

    public void addPart(PartCreateFromJsonDTO part) {
        this.parts.add(part);
    }

    public void removePart(PartCreateFromJsonDTO part) {
        this.parts.remove(part);
    }
}