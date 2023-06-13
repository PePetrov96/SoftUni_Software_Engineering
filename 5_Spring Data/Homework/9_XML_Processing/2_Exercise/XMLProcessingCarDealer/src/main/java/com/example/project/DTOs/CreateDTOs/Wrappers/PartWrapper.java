package com.example.project.DTOs.CreateDTOs.Wrappers;

import com.example.project.DTOs.CreateDTOs.PartDTO;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartWrapper {
    @XmlElement(name = "part")
    private List<PartDTO> parts;

    public PartWrapper(List<PartDTO> parts) {
        this.parts = parts;
    }

    public PartWrapper() {
    }

    public List<PartDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartDTO> parts) {
        this.parts = parts;
    }
}
