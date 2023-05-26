package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllBooksByCategories(String name) {
        Category category = this.categoryService.getCategoryByName(name);
        return this.bookRepository.getBooksByCategoriesContaining(category);
    }

    @Override
    public List<Book> findAllBooksByAgeRestriction(String ageRestriction) {
        AgeRestriction age = AgeRestriction.valueOf(ageRestriction.toUpperCase());

        return this.bookRepository.getBooksByAgeRestriction(age);
    }

    @Override
    public List<Book> findAllBooksByEditionAndCopies(String editionType, int copies) {
        EditionType edition = EditionType.valueOf(editionType.toUpperCase());
        return this.bookRepository.getBooksByEditionTypeAndCopies(edition, copies);
    }

    @Override
    public List<Book> findAllBooksByPrice(BigDecimal below, BigDecimal above) {
        return this.bookRepository.getAllBooksByPrice(below, above);
    }

    @Override
    public List<Book> findAllBooksByReleaseDateIsNot(int year) {
        return this.bookRepository.getAllBooksByReleaseDateIsNot(year);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(LocalDate date) {
        return this.bookRepository.getAllByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findAllByTitleContaining(String string) {
        return this.bookRepository.getAllByTitleContainsIgnoreCase(string);
    }

    @Override
    public List<Book> findAllBooksByAuthorLastNameStartsWith(String string) {
        return this.bookRepository.getAllBooksByAuthorLastNameStartsWith(string);
    }

    @Override
    public long countBooksByTitleLength(int length) {
        return this.bookRepository.countBooksByTitleLength(length);
    }

    @Override
    public List<Long> getCountByAuthorFullName() {
        return this.bookRepository.getCountByAuthorFullName();
    }

    @Override
    public int increaseCopiesReleasedAfterDate(int copiesToAdd, LocalDate releaseDate) {
        return this.bookRepository.increaseCopiesReleasedAfterDate(copiesToAdd, releaseDate);
    }

    @Override
    public Book getBookByTitle(String title) {
        return this.bookRepository.getBookByTitle(title);
    }

    @Override
    public int deleteBooksByCopiesLowerThan(int copiesToDelete) {
        return bookRepository.deleteBooksByCopiesLowerThan(copiesToDelete);
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
