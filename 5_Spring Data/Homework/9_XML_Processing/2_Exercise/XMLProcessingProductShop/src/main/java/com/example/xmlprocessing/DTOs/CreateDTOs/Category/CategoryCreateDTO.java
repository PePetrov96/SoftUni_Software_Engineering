package com.example.xmlprocessing.DTOs.CreateDTOs.Category;

import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryCreateDTO implements Serializable {
    @XmlElement(name = "name")
    private String name;

    public CategoryCreateDTO(String name) {
        this.name = name;
    }

    public CategoryCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}