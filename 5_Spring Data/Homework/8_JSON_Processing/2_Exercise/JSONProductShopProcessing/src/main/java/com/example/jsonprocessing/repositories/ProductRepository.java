package com.example.jsonprocessing.repositories;

import com.example.jsonprocessing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetweenAndBuyerIsNullOrderByPriceAsc(double minPrice, double maxPrice);
}