package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService{
    private ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findBySize(Size size) {
        return this.shampooRepository
                .getAllBySizeOrderById(size)
                .stream()
                .toList();
    }

    @Override
    public List<Shampoo> findByBrandAndSize(String brand, Size size) {
        return null;
    }
}