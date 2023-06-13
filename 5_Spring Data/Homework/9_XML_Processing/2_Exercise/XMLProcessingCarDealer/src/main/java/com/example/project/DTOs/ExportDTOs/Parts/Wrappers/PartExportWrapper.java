package com.example.project.DTOs.ExportDTOs.Parts.Wrappers;

import com.example.project.DTOs.ExportDTOs.Parts.PartExportDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartExportWrapper {
    @XmlElement(name = "part")
    private List<PartExportDTO> parts;

    public PartExportWrapper(List<PartExportDTO> parts) {
        this.parts = parts;
    }

    public PartExportWrapper() {
    }

    public List<PartExportDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartExportDTO> parts) {
        this.parts = parts;
    }
}
