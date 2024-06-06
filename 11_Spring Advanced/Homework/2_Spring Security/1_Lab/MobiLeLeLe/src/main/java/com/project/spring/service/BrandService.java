package com.project.spring.service;

import com.project.spring.models.entity.Brand;

import java.util.List;

public interface BrandService {
    boolean hasInitialized();
    void importBrands();
    String readBrandFileContent();
    List<Brand> postBrands();
}
