package com.example.project.repositories;

import com.example.project.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT s FROM Supplier AS s WHERE s.isImporter = false")
    List<Supplier> findSuppliersByImporterIs();
}
