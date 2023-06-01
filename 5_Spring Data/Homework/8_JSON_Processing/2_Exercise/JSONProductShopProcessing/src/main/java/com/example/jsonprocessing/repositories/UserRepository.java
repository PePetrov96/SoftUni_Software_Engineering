package com.example.jsonprocessing.repositories;

import com.example.jsonprocessing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT COUNT(u.id) FROM User AS u")
    int countAll();
    List<User> findAllBySoldProductsIsNotEmptyOrderByLastNameAscFirstNameAsc();
    List<User> findAllBySoldProductsIsNotEmptyOrderBySoldProductsDescLastNameAsc();
}