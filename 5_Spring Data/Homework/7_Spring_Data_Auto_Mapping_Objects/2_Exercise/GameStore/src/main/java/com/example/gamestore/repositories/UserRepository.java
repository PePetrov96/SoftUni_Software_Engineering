package com.example.gamestore.repositories;

import com.example.gamestore.model.Administrator;
import com.example.gamestore.model.BaseUser;
import com.example.gamestore.model.dtos.AdminDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BaseUser, Long> {
    BaseUser findByEmail(String email);
    BaseUser findBaseUserByEmailAndPassword(String email, String password);
    Administrator findBaseUserByAdministratorIs(boolean condition);
    AdminDto findByAdministratorIs(boolean condition);
}