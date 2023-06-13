package com.example.project.DTOs.ExportDTOs.Suppliers;

import com.example.project.model.Part;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierExportDTO {
    @XmlAttribute(name = "id")
    private Long id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "parts-count")
    private long count;

    public SupplierExportDTO(Long id, String name, List<Part> parts) {
        this.id = id;
        this.name = name;
        this.count = parts.size();
    }

    public SupplierExportDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
