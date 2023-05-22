package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.util.List;

public interface ShampooService {
    List<Shampoo> findBySize(Size size);
    List<Shampoo> findByBrandAndSize(String brand, Size size);
}