package com.example.xmlprocessing.services.Impl;

import com.example.xmlprocessing.DTOs.ExportDTOs.Product.ProductsSellerDTO;
import com.example.xmlprocessing.DTOs.ExportDTOs.Product.ProductsSellerWrapper;
import com.example.xmlprocessing.DTOs.ExportDTOs.Product.SoldProductWrapper;
import com.example.xmlprocessing.DTOs.ExportDTOs.User.UserExportDTO;
import com.example.xmlprocessing.DTOs.ExportDTOs.User.UserExportWrapper;
import com.example.xmlprocessing.DTOs.ExportDTOs.User.UsersProductsExportDTO;
import com.example.xmlprocessing.DTOs.ExportDTOs.User.UsersProductsExportWrapper;
import com.example.xmlprocessing.model.Product;
import com.example.xmlprocessing.model.User;
import com.example.xmlprocessing.repositories.UserRepository;
import com.example.xmlprocessing.services.UserService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper MODDEL_MAPPER;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.MODDEL_MAPPER = mapper;
    }


    @Override
    @Transactional(readOnly = true)
    public void exportUsersWithSoldProducts() {
        List<User> users = this.userRepository
                .findAllBySellingProductsIsNotNull()
                .stream()
                .filter(user -> user.getSellingProducts().stream()
                        .anyMatch(product -> product.getBuyer() != null))
                .sorted(Comparator.comparing(User::getFirstName, Comparator.nullsLast(String::compareTo))
                        .thenComparing(User::getLastName, Comparator.nullsLast(String::compareTo)))
                .toList();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/exports/task_2.xml"))) {

            JAXBContext context = JAXBContext.newInstance(UserExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            UserExportWrapper exportWrapper = new UserExportWrapper(users
                    .stream()
                    .map(user -> new UserExportDTO(
                            user.getFirstName(),
                            user.getLastName(),
                            mapToProductSellerWrapper(user.getSellingProducts())))
                    .collect(Collectors.toList()));

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void exportUsersAndProducts() {
        List<User> userList = this.userRepository.findAllBySellingProductsIsNotNull();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/resources/exports/task_4.xml"))) {
            JAXBContext context = JAXBContext.newInstance(UsersProductsExportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            UsersProductsExportWrapper exportWrapper = new UsersProductsExportWrapper(
                    userList.stream()
                            .map(user -> new UsersProductsExportDTO(
                                    user.getFirstName(),
                                    user.getLastName(),
                                    user.getAge(),
                                    user.getSellingProducts()
                            ))
                            .sorted(Comparator.comparingInt(UsersProductsExportDTO::getProductCount).reversed()
                                    .thenComparing(UsersProductsExportDTO::getLastName))
                            .collect(Collectors.toList())
            );

            marshaller.marshal(exportWrapper, writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ProductsSellerWrapper mapToProductSellerWrapper(List<Product> products) {
        List<Product> filteredProducts = products
                .stream()
                .filter(product -> product.getBuyer() != null)
                .toList();

        return new ProductsSellerWrapper(
                filteredProducts.stream()
                        .map(product -> new ProductsSellerDTO(
                                product.getName(),
                                product.getPrice(),
                                product.getBuyer().getFirstName(),
                                product.getBuyer().getLastName()))
                        .collect(Collectors.toList()));
    }
}