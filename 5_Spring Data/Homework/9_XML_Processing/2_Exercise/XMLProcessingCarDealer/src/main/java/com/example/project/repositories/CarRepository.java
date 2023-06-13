package com.example.project.repositories;

import com.example.project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllBySaleIsNull();
    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
