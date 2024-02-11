package com.project.spring.service;

import com.project.spring.models.entity.Brand;

import java.util.List;

public interface BrandService {
    void importBrands();
    String readBrandFileContent();
    boolean isInitializes();
    List<Brand> postBrands();
}
