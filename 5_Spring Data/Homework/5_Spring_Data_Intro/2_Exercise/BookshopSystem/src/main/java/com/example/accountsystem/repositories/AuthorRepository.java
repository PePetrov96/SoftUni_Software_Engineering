package com.example.accountsystem.repositories;

import com.example.accountsystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
    Optional<Author> findAuthorByLastName(String lastName);

    List<Author> findAll();
}