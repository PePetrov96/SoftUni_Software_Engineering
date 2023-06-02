package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.config.GsonBuilderWrapper;
import com.example.jsonprocessing.model.DTOs.SupplierCreateFromJsonDTO;
import com.example.jsonprocessing.model.DTOs.SupplierJsonExportDTO;
import com.example.jsonprocessing.model.Supplier;
import com.example.jsonprocessing.repositories.SupplierRepository;
import com.example.jsonprocessing.services.SupplierService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
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
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/suppliers.json"))) {

            SupplierCreateFromJsonDTO[] supplierDtos = this.gson.fromJson(reader,
                    SupplierCreateFromJsonDTO[].class);

            for (SupplierCreateFromJsonDTO supplierDto:supplierDtos) {
                Supplier supplier =this.mapper.map(supplierDto, Supplier.class);
                this.supplierRepository.save(supplier);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        this.supplierRepository.flush();
    }

    @Override
    @Transactional(readOnly = true)
    public void exportLocalSuppliers() {
        List<Supplier> suppliers = this.supplierRepository.findLocalSuppliers();

        List<SupplierJsonExportDTO> supplierDTOs = suppliers.stream()
                .map(this::convertToJsonExport)
                .toList();

        String filePath = "src/main/resources/exports/Task_3_Local_Suppliers.json";

        List<String> fields = new ArrayList<>(); fields.add("IsImporter");
        Gson gsonNew = new GsonBuilderWrapper(fields).createGson();

        try (FileWriter writer = new FileWriter(filePath)) {
            gsonNew.toJson(supplierDTOs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SupplierJsonExportDTO convertToJsonExport(Supplier supplier) {
        return new SupplierJsonExportDTO(
                supplier.getId(),
                supplier.getName(),
                supplier.getParts().size());
    }
}