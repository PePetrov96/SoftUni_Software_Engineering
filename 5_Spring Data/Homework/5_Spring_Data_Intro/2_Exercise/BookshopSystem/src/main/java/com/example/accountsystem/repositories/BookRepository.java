package com.example.accountsystem.repositories;

import com.example.accountsystem.model.Author;
import com.example.accountsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);
    Optional<Book> findBookByAuthor(Author author);
    Optional<Book> findBookByReleaseDate(Date date);
}