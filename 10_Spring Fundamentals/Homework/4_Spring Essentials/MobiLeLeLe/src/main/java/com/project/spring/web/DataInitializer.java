package com.project.spring.web;

import com.project.spring.service.BrandService;
import com.project.spring.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;

    @Autowired
    public DataInitializer(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) {
        if (!this.brandService.hasInitialized()) {
            this.brandService.importBrands();
        }

        if (!this.modelService.hasInitialized()) {
            this.modelService.importModels();
        }
    }
}
