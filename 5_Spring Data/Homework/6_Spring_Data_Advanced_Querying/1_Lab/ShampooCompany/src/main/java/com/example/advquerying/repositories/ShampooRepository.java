package com.example.advquerying.repositories;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> getAllBySizeOrderById(Size sizeValue);
    List<Shampoo> getAllBySizeOrLabelOrderByPrice(Size size, Label label);
    List<Shampoo> getAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    long countShampoosByPriceLessThan(BigDecimal price);
}