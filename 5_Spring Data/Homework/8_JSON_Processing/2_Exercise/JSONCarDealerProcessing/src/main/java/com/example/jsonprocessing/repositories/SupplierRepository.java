package com.example.jsonprocessing.repositories;

import com.example.jsonprocessing.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findById(Long id);
    @Query(value = "SELECT s FROM Supplier AS s WHERE s.isImporter = false ")
    List<Supplier> findLocalSuppliers();
}