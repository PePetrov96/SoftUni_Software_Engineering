package com.example.xmlprocessing.DTOs.ExportDTOs.Category;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryExportWrapper {
    @XmlElement(name = "category")
    private List<CategoryExportDTO> categories;

    public CategoryExportWrapper(List<CategoryExportDTO> categories) {
        this.categories = categories;
    }

    public CategoryExportWrapper() {
    }

    public List<CategoryExportDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryExportDTO> categories) {
        this.categories = categories;
    }
}
