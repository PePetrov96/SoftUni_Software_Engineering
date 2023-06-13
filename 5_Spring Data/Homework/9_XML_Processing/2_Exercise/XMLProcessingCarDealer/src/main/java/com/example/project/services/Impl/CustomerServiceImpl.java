package com.example.project.services.Impl;

import com.example.project.DTOs.ExportDTOs.Customers.CustomerExportDTO;
import com.example.project.DTOs.ExportDTOs.Customers.CustomerSalesDTO;
import com.example.project.DTOs.ExportDTOs.Customers.Wrappers.CustomerExportWrapper;
import com.example.project.DTOs.ExportDTOs.Customers.Wrappers.CustomerSalesWrapper;
import com.example.project.model.Customer;
import com.example.project.repositories.CustomerRepository;
import com.example.project.services.CustomerService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper MODDEL_MAPPER;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper moddelMapper) {
        this.customerRepository = customerRepository;
        this.MODDEL_MAPPER = moddelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public void exportOrderedCustomers() {
        List<Customer> customerList = this.customerRepository
                .findAllOrderByBirthDateAscYoungDriverAsc();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/export/task_1.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CustomerExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CustomerExportWrapper exportWrapper = new CustomerExportWrapper(
                    customerList.stream()
                            .map(customer -> new CustomerExportDTO(
                                    customer.getId(),
                                    customer.getName(),
                                    customer.getBirthDate(),
                                    customer.isYoungDriver()))
                            .toList()
            );

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void exportCustomerSales() {
        List<Customer> customerList = this.customerRepository
                .findCustomersBySalesIsNotEmpty();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/export/task_5.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CustomerSalesWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CustomerSalesWrapper exportWrapper = new CustomerSalesWrapper(
                    customerList.stream()
                            .map(customer -> new CustomerSalesDTO(
                                    customer.getName(),
                                    customer.getSales()
                            )).toList());

            // Sort by pentMoney in descending order
            Comparator<CustomerSalesDTO> sortByPentMoneyDesc = Comparator.comparing(CustomerSalesDTO::getSpentMoney).reversed();
            // Sort by boughtCars in descending order
            Comparator<CustomerSalesDTO> sortByBoughtCarsDesc = Comparator.comparingLong(CustomerSalesDTO::getBoughtCars).reversed();
            // Create a mutable copy of the list
            List<CustomerSalesDTO> mutableCustomers = new ArrayList<>(exportWrapper.getCustomers());
            // Sort the mutable list
            mutableCustomers.sort(sortByPentMoneyDesc.thenComparing(sortByBoughtCarsDesc));
            // Update the exportWrapper with the sorted list
            exportWrapper.setCustomers(mutableCustomers);

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
