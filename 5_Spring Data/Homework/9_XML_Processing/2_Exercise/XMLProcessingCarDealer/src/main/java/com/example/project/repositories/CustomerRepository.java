package com.example.project.repositories;

import com.example.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate ASC, c.isYoungDriver ASC")
    List<Customer> findAllOrderByBirthDateAscYoungDriverAsc();
    List<Customer> findCustomersBySalesIsNotEmpty();

}
