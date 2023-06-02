package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.model.DTOs.PartCreateFromJsonDTO;
import com.example.jsonprocessing.model.Part;
import com.example.jsonprocessing.model.Supplier;
import com.example.jsonprocessing.repositories.PartRepository;
import com.example.jsonprocessing.repositories.SupplierRepository;
import com.example.jsonprocessing.services.PartService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private Long supplierSize;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository,
                           ModelMapper modelMapper) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;

        this.mapper = modelMapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();

    }

    @Override
    @Transactional
    public void seedData() {
        this.supplierSize = (long) this.supplierRepository.findAll().size();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/parts.json"))) {
            PartCreateFromJsonDTO[] partDTOs = this.gson.fromJson(reader, PartCreateFromJsonDTO[].class);

            for (PartCreateFromJsonDTO partDto:partDTOs) {
                Supplier supplier = getRandomSupplier();
                Part part = this.mapper.map(partDto, Part.class);
                part.setSupplier(supplier);

                this.partRepository.save(part);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.partRepository.flush();
    }

    private Supplier getRandomSupplier() {
        long index = ThreadLocalRandom.current().nextLong(supplierSize) + 1;
        return this.supplierRepository.findById(index).orElse(null);
    }
}
