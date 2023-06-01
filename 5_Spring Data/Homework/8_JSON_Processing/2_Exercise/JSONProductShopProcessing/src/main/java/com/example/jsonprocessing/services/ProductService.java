package com.example.jsonprocessing.services;

public interface ProductService {
    void importProductsFromJson();
    void exportProductsToJSON(double minPrice, double maxPrice, String fileName);
}
