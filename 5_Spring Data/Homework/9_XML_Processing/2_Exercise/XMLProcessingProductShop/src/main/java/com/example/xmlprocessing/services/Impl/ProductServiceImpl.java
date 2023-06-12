package com.example.xmlprocessing.services.Impl;

import com.example.xmlprocessing.DTOs.ExportDTOs.Product.ProductExportDTO;
import com.example.xmlprocessing.DTOs.ExportDTOs.Product.ProductExportWrapper;
import com.example.xmlprocessing.model.Product;
import com.example.xmlprocessing.repositories.ProductRepository;
import com.example.xmlprocessing.services.ProductService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper MODDEL_MAPPER;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.MODDEL_MAPPER = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public void exportProductsInRange(int min, int max) {
        List<Product> productList = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(new BigDecimal(min), new BigDecimal(max));

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/exports/task_1.xml"))) {

            JAXBContext context = JAXBContext.newInstance(ProductExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            ProductExportWrapper exportWrapper = new ProductExportWrapper(
                    productList.stream()
                            .map(product -> new ProductExportDTO(
                                    product.getName(),
                                    product.getPrice(),
                                    product.getSeller().getFirstName(),
                                    product.getSeller().getLastName()))
                            .collect(Collectors.toList()));

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}