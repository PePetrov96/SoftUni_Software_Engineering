package springdatalab.service;

import springdatalab.models.entities.Product;
import springdatalab.models.service.ProductServiceModel;

public interface ProductService {

    void addProduct(ProductServiceModel productServiceModel);

    void addProductDistribution(String productName, String[] shopList);

    Product findByName(String name);
}
