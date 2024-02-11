package com.project.spring.web;

import com.project.spring.service.BrandService;
import com.project.spring.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

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
    public void run(String... args) throws Exception {
        initializeBrands();
        initializeModels();
    }

    private void initializeBrands() {
        this.brandService.importBrands();
    }

    private void initializeModels() {
        this.modelService.importModels();
    }

}
