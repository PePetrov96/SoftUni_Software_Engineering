package com.example.xmlprocessing.services.Impl;

import com.example.xmlprocessing.DTOs.CreateDTOs.Category.CategoriesCreateDTO;
import com.example.xmlprocessing.DTOs.CreateDTOs.Category.CategoryCreateDTO;
import com.example.xmlprocessing.DTOs.CreateDTOs.Product.ProductCreateDTO;
import com.example.xmlprocessing.DTOs.CreateDTOs.Product.ProductsCreateDTO;
import com.example.xmlprocessing.DTOs.CreateDTOs.User.UserCreateDTO;
import com.example.xmlprocessing.DTOs.CreateDTOs.User.UsersCreateDTO;
import com.example.xmlprocessing.model.Category;
import com.example.xmlprocessing.model.Product;
import com.example.xmlprocessing.model.User;
import com.example.xmlprocessing.repositories.CategoryRepository;
import com.example.xmlprocessing.repositories.ProductRepository;
import com.example.xmlprocessing.repositories.UserRepository;
import com.example.xmlprocessing.services.SeedService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Random;

@Service
public class SeedServiceImpl implements SeedService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ModelMapper MODDEL_MAPPER;
    private long categorySize;
    private long userSize;

    public SeedServiceImpl(ProductRepository productRepository,
                           CategoryRepository categoryRepository,
                           UserRepository userRepository,
                           ModelMapper moddelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.MODDEL_MAPPER = moddelMapper;
        this.categorySize = this.categoryRepository.count();
        this.userSize = this.userRepository.count();
    }

    @Override
    @Transactional
    public void seedCategories() {
        if (this.categoryRepository.count() > 0) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/imports/categories.xml"))) {
            JAXBContext context = JAXBContext.newInstance(CategoriesCreateDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            CategoriesCreateDTO categoryDTOs = (CategoriesCreateDTO) unmarshaller.unmarshal(reader);

            for (CategoryCreateDTO categoryDTO: categoryDTOs.getCategoryCreateDTOs()) {
                this.categoryRepository
                        .save(MODDEL_MAPPER.map(categoryDTO, Category.class));
            }

            this.categoryRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void seedProducts() {
        if (this.productRepository.count() > 0) {
            return;
        }

        this.categorySize = this.categoryRepository.count();
        this.userSize = this.userRepository.count();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/imports/products.xml"))) {

            JAXBContext context = JAXBContext.newInstance(ProductsCreateDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            ProductsCreateDTO productsDTOs = (ProductsCreateDTO) unmarshaller.unmarshal(reader);

            for (ProductCreateDTO productDTO: productsDTOs.getProductCreateDTOs()) {
                Product product = this.MODDEL_MAPPER.map(productDTO, Product.class);
                User seller = getRandomSeller(); //get the seller separately in order NOT to set the seller and the buyer the same person

                product.setSeller(seller);

                if (new Random().nextBoolean()) { //get a random boolean whether to set a buyer or not
                    product.setBuyer(getRandomBuyer(seller));}

                product.setCategory(getRandomCategory());

                this.productRepository.save(product);
            }

            this.productRepository.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    public void seedUsers() {
        if (this.userRepository.count() > 0) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/imports/users.xml"))) {

            JAXBContext context = JAXBContext.newInstance(UsersCreateDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            UsersCreateDTO userDTOs = (UsersCreateDTO) unmarshaller.unmarshal(reader);

            for (UserCreateDTO userDTO: userDTOs.getUserCreateDTOs()) {
                this.userRepository
                        .save(MODDEL_MAPPER.map(userDTO, User.class));
            }

            this.userRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private User getRandomSeller() {
        Random rnd = new Random();
        long index = rnd.nextLong(userSize) + 1;

        return this.userRepository.findById(index).orElse(null);
    }

    private User getRandomBuyer(User seller) {
        Random rnd = new Random();
        long index = rnd.nextLong(userSize) + 1;

        User buyer = this.userRepository.findById(index).orElse(null);

        if (buyer != null && Objects.equals(buyer.getId(), seller.getId())) {
            return getRandomBuyer(seller); // recursively get a new buyer
        }

        return buyer;
    }

    private Category getRandomCategory() {
        Random rnd = new Random();
        long index = rnd.nextLong(categorySize) + 1;

        return this.categoryRepository.findById(index).orElse(null);
    }
}
