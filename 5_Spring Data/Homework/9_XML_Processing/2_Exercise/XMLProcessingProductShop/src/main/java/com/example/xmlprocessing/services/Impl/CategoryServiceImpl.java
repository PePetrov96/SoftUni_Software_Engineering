package com.example.xmlprocessing.services.Impl;

import com.example.xmlprocessing.DTOs.ExportDTOs.Category.CategoryExportDTO;
import com.example.xmlprocessing.DTOs.ExportDTOs.Category.CategoryExportWrapper;
import com.example.xmlprocessing.model.Category;
import com.example.xmlprocessing.repositories.CategoryRepository;
import com.example.xmlprocessing.services.CategoryService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper MODDEL_MAPPER;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.MODDEL_MAPPER = mapper;
    }


    @Override
    @Transactional(readOnly = true)
    public void exportCategoriesByProductsCount() {
        List<Category> categoryList = this.categoryRepository.findAll();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/exports/task_3.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CategoryExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CategoryExportWrapper exportWrapper = new CategoryExportWrapper(
                    categoryList.stream()
                            .map(category -> new CategoryExportDTO(
                                    category.getName(),
                                    category.getProducts()))
                            .sorted(Comparator.comparingLong(CategoryExportDTO::getProductCount)
                                    .reversed())
                            .collect(Collectors.toList()));

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}