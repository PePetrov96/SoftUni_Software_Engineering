package com.example.jsonprocessing.services.Impl;

import com.example.jsonprocessing.model.Car;
import com.example.jsonprocessing.model.Customer;
import com.example.jsonprocessing.model.Sale;
import com.example.jsonprocessing.repositories.CarRepository;
import com.example.jsonprocessing.repositories.CustomerRepository;
import com.example.jsonprocessing.repositories.SaleRepository;
import com.example.jsonprocessing.services.SaleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private long customerSize;
    private long carSize;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository, ModelMapper mapper) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;

        this.mapper = mapper;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    @Transactional
    public void seedData() {
        this.carSize = this.carRepository.findAll().size();
        this.customerSize = this.customerRepository.findAll().size();


        for (int i = 1; i <= carSize; i++) { //for each Car, make a new Sale entry
            Car car = this.carRepository.findById((long) i).orElse(null);
            Customer customer = getRandomCustomer();

            if (car == null || customer == null) {
                continue;
            }

            Sale sale = new Sale(car, customer, getRandomDiscount());

            this.saleRepository.save(sale);
        }

        this.saleRepository.flush();
    }

    private Customer getRandomCustomer() {
        long index = ThreadLocalRandom.current().nextLong(customerSize) + 1;
        return this.customerRepository.findById(index).orElse(null);
    }

    private BigDecimal getRandomDiscount() {
        String[] discounts = {"5", "10","15","20","25","30","35","40","45","50"};
        Random rnd = new Random();
        int index = rnd.nextInt(discounts.length);
        return new BigDecimal(discounts[index]);
    }
}