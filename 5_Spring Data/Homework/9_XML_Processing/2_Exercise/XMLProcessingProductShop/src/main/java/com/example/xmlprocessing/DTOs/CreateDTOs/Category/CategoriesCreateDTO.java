package com.example.xmlprocessing.DTOs.CreateDTOs.Category;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesCreateDTO implements Serializable {
    @XmlElement(name = "category")
    private List<CategoryCreateDTO> categoryCreateDTOs;

    public CategoriesCreateDTO() {
        this.categoryCreateDTOs = new ArrayList<>();
    }

    public List<CategoryCreateDTO> getCategoryCreateDTOs() {
        return categoryCreateDTOs;
    }

    public void setCategoryCreateDTOs(List<CategoryCreateDTO> categoryCreateDTOs) {
        this.categoryCreateDTOs = categoryCreateDTOs;
    }
}
