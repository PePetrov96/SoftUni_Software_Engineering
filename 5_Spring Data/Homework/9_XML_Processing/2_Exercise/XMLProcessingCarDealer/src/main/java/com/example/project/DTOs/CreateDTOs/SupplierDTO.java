package com.example.project.DTOs.CreateDTOs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDTO {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "is-importer")
    private boolean isImporter;

    public SupplierDTO(String name, boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
    }

    public SupplierDTO() {
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
}
