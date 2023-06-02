package com.example.jsonprocessing.repositories;

import com.example.jsonprocessing.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT c FROM Customer AS c ORDER BY c.birthDate, c.isYoungDriver")
    List<Customer> getCustomersOrderedByBirthdateAndAndYoungDriver();
    List<Customer> getCustomersBySalesNotEmpty();
}