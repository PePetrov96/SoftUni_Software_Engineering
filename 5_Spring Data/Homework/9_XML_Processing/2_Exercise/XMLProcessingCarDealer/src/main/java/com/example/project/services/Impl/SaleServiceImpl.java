package com.example.project.services.Impl;

import com.example.project.DTOs.ExportDTOs.Cars.CarSaleExportDTO;
import com.example.project.DTOs.ExportDTOs.Customers.CustomerExportDTO;
import com.example.project.DTOs.ExportDTOs.Customers.Wrappers.CustomerExportWrapper;
import com.example.project.DTOs.ExportDTOs.Sales.SaleExportDTO;
import com.example.project.DTOs.ExportDTOs.Sales.Wrapper.SaleExportWrapper;
import com.example.project.model.Sale;
import com.example.project.repositories.SaleRepository;
import com.example.project.services.SaleService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public void exportSalesWithDiscounts() {
        List<Sale> saleList = this.saleRepository.findAll();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/export/task_6.xml"))) {
            JAXBContext context = JAXBContext.newInstance(SaleExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            SaleExportWrapper exportWrapper = new SaleExportWrapper(
                    saleList.stream()
                            .map(sale -> new SaleExportDTO(
                                    sale.getCar(),
                                    sale.getCustomer().getName(),
                                    sale.getDiscount()
                            )).toList());

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
