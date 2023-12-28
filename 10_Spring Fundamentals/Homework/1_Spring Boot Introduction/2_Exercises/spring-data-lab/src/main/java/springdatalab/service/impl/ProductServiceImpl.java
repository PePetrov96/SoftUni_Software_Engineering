package springdatalab.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdatalab.models.entities.Product;
import springdatalab.models.entities.Shop;
import springdatalab.models.service.ProductServiceModel;
import springdatalab.repositories.ProductRepository;
import springdatalab.service.CategoryService;
import springdatalab.service.ProductService;
import springdatalab.service.ShopService;
import springdatalab.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import java.util.Arrays;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final CategoryService categoryService;
    private final ShopService shopService;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, CategoryService categoryService, ShopService shopService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.categoryService = categoryService;
        this.shopService = shopService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {

        if (!this.validationUtil.isValid(productServiceModel)) {

            this.validationUtil
                    .violations(productServiceModel)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        this.productRepository.saveAndFlush(product);

    }

    @Override
    public void addProductDistribution(String productName, String[] shopList) {
        Product product = this.productRepository
                .findByName(productName);

        Arrays.stream(shopList)
                .forEach(s -> {
                    Shop shop = this.shopService.findShopByName(s);

                    product.getShops()
                            .add(shop);
                });

        this.productRepository.saveAndFlush(product);
    }

    @Override
    public Product findByName(String name) {
        return this.productRepository.findByName(name);
    }
}
