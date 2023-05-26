package com.example.springintro.repository;

import com.example.springintro.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author AS a ORDER BY a.books.size DESC")
    List<Author> findAllByBooksSizeDESC();
    List<Author> findAuthorsByFirstNameEndingWith(String string);
    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);
    @Procedure(value = "GetTotalBooksByAuthor")
    int countTotalBooks(@Param("authorFirstName") String authorFirstName, @Param(value = "authorLastName") String authorLastName);
}
