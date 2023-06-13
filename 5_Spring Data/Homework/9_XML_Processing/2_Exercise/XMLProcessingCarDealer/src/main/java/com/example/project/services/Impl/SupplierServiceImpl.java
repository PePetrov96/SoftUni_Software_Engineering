package com.example.project.services.Impl;

import com.example.project.DTOs.ExportDTOs.Suppliers.SupplierExportDTO;
import com.example.project.DTOs.ExportDTOs.Suppliers.Wrappers.SupplierExportWrapper;
import com.example.project.model.Supplier;
import com.example.project.repositories.SupplierRepository;
import com.example.project.services.SupplierService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void exportLocalSuppliers() {
        List<Supplier> supplierList = this.supplierRepository
                .findSuppliersByImporterIs();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/export/task_3.xml"))) {
            JAXBContext context = JAXBContext.newInstance(SupplierExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SupplierExportWrapper exportWrapper = new SupplierExportWrapper(
                    supplierList.stream()
                            .map(supplier -> new SupplierExportDTO(
                                    supplier.getId(),
                                    supplier.getName(),
                                    supplier.getParts()))
                            .toList());

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
