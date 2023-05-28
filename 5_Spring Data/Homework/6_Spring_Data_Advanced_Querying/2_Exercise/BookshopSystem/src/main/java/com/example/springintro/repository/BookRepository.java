package com.example.springintro.repository;

import com.example.springintro.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    @Query(value = "SELECT b.title FROM Book AS b WHERE b.categories IN :category")
    List<Book> getBooksByCategoriesContaining(@Param(value = "category") Category category);

    @Query(value = "SELECT b FROM Book AS b WHERE b.ageRestriction = :ageRestriction")
    List<Book> getBooksByAgeRestriction(@Param(value = "ageRestriction") AgeRestriction ageRestriction);

    @Query(value = "SELECT b FROM Book AS b WHERE b.editionType = :editionType AND b.copies <= :copies")
    List<Book> getBooksByEditionTypeAndCopies(@Param(value = "editionType") EditionType editionType, @Param(value = "copies") int copies);

    @Query(value = "SELECT b FROM Book AS b WHERE b.price < :belowPrice OR b.price > :abovePrice")
    List<Book> getAllBooksByPrice(@Param(value = "belowPrice")BigDecimal belowPrice, @Param(value = "abovePrice")BigDecimal abovePrice);

    @Query(value = "SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) <> :year")
    List<Book> getAllBooksByReleaseDateIsNot(@Param(value = "year")int year);

    List<Book> getAllByReleaseDateBefore(LocalDate beforeDate);

    List<Book> getAllByTitleContainsIgnoreCase(String string);

    @Query(value = "SELECT b FROM Book AS b JOIN b.author AS a WHERE a.lastName LIKE :string%")
    List<Book> getAllBooksByAuthorLastNameStartsWith(@Param(value = "string") String string);

    @Query(value = "SELECT COUNT(b.id) FROM Book AS b WHERE LENGTH(b.title) > :length")
    long countBooksByTitleLength(@Param(value = "length")int length);
    @Query(value = "SELECT SUM(b.copies) FROM Book AS b GROUP BY b.author.id ORDER BY SUM(b.copies) DESC")
    List<Long> getCountByAuthorFullName();

    Book getBookByTitle(String title);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Book AS b SET b.copies = b.copies + :copiesToAdd WHERE b.releaseDate > :releaseDate")
    int increaseCopiesReleasedAfterDate(@Param("copiesToAdd") int copiesToAdd, @Param("releaseDate") LocalDate releaseDate);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Book AS b WHERE b.copies < :copiesToDelete")
    int deleteBooksByCopiesLowerThan(@Param("copiesToDelete") int copiesToDelete);
}