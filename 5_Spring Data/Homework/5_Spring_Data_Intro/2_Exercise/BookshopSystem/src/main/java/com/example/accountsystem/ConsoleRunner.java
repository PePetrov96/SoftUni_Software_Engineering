package com.example.accountsystem;

import com.example.accountsystem.enums.AgeRestriction;
import com.example.accountsystem.enums.EditionType;
import com.example.accountsystem.model.Author;
import com.example.accountsystem.model.Book;
import com.example.accountsystem.model.Category;
import com.example.accountsystem.services.AuthorService;
import com.example.accountsystem.services.BookService;
import com.example.accountsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public ConsoleRunner(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
    }
    @Transactional
    public void seedDatabaseWithAuthors() {
        Path path = Paths.get("src/main/resources/authors.txt");
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {
            String[] authorLine = line.trim().split("\\s+");

            Author author = new Author(authorLine[0], authorLine[1]);
            this.authorService.registerAuthor(author);
        }
    }
    @Transactional
    public void seedDatabaseWithCategories() {
        Path path = Paths.get("src/main/resources/categories.txt");
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {
            String categoryName = line.trim();

            Category category = new Category(categoryName);
            this.categoryService.registerCategory(category);
        }
    }

    @Transactional
    public void seedDatabaseWithBooks() {
        Path path = Paths.get("src/main/resources/books.txt");
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {
            String[] data = line.trim().split("\\s+");

            EditionType editionType = EditionType.fromValue(Integer.parseInt(data[0]));
            String dateFormat = data[1];
            long copies = Long.parseLong(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.fromValue(Integer.parseInt(data[4]));
            String title = Arrays.stream(data) .skip(5) .collect(Collectors.joining(" "));

            Author author = this.authorService.getRandomAuthor();
            Category category = this.categoryService.getRandomCategory();

            Book book = new Book(title, editionType, dateFormat, price, copies, ageRestriction, author, category);

            this.bookService.registerBook(book);
        }
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedDatabaseWithAuthors();
        seedDatabaseWithCategories();
        seedDatabaseWithBooks();
    }
}