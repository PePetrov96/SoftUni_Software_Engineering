package com.example.jsonprocessing.repositories;

import com.example.jsonprocessing.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT COUNT(c.id) FROM Category AS c")
    int countAll();
}
