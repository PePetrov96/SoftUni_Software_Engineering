package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllBooksByCategories(String name);

    List<Book> findAllBooksByAgeRestriction(String ageRestriction);

    List<Book> findAllBooksByEditionAndCopies(String editionType, int copies);

    List<Book> findAllBooksByPrice(BigDecimal below, BigDecimal above);

    List<Book> findAllBooksByReleaseDateIsNot(int year);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContaining(String string);

    List<Book> findAllBooksByAuthorLastNameStartsWith(String string);

    long countBooksByTitleLength(int length);

    List<Long> getCountByAuthorFullName();

    Book getBookByTitle(String title);

    int increaseCopiesReleasedAfterDate(int copiesToAdd, LocalDate releaseDate);

    int deleteBooksByCopiesLowerThan(int copiesToDelete);
}