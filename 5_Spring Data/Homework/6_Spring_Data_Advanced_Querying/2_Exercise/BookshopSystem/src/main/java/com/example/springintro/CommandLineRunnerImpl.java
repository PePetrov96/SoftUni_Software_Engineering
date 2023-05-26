package com.example.springintro;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        task_1();  //Input: miNor
                   //Input: teEN

        task_2();  //

        task_3();  //

        task_4();  //Input: 2000
                   //Input: 1998

        task_5();  //Input: 12-04-1992
                   //Input: 30-12-1989

        task_6();  //Input: e
                   //Input: dy

        task_7();  //Input: sK
                   //Input: WOR

        task_8();  //Input: Ric
                   //Input: gr

        task_9();  //Input: 12
                   //Input: 40

        task_10(); //

        task_11(); //Input: Things Fall Apart

        task_12(); //Input:
                   //12 Oct 2005
                   //100

                   //Input:
                   //06 Jun 2013
                   //44

        task_13(); //Input: 1000

        task_14(); //Input: Amanda Rice
                   //Input: Christina Jordan
                   //Input: Wanda Morales

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void task_1() throws IOException {
        System.out.print("Books Titles by Age Restriction (Minor, Teen, Adult): ");

        String input = reader.readLine();
        List<Book> books = this.bookService.findAllBooksByAgeRestriction(input);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }
    private void task_2() throws IOException {
        List<Book> books = this.bookService.findAllBooksByEditionAndCopies("gold", 5000);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private void task_3() throws IOException {
        List<Book> books = this.bookService.findAllBooksByPrice(new BigDecimal("5"), new BigDecimal("40"));

        for (Book book : books) {
            System.out.println(book.getTitle() + " - $" + book.getPrice());
        }
    }

    private void task_4() throws IOException {
        System.out.print("Enter the release date, which you do NOT want to see: ");
        int year = Integer.parseInt(reader.readLine());

        List<Book> books = this.bookService.findAllBooksByReleaseDateIsNot(year);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private void task_5() throws IOException {
        System.out.print("Enter the date (dd-MM-yyyy) to get all books released: ");

        String date = reader.readLine(); //12-04-1992

        LocalDate releaseDate = LocalDate
                .parse(date, DateTimeFormatter.ofPattern("d-M-yyyy"));

        List<Book> books = this.bookService.findAllByReleaseDateBefore(releaseDate);

        for (Book book : books) {
            System.out.printf("%s %s %.2f%n", book.getTitle(), book.getEditionType(), book.getPrice());
        }
    }

    private void task_6() throws IOException {
        System.out.print("Author first name ends with a given string: ");
        String input = reader.readLine();

        List<Author> authors = this.authorService.getAllAuthorsByNameEndingWith(input);

        for (Author author : authors) {
            System.out.println(author.getFirstName() + " " + author.getLastName());
        }
    }

    private void task_7() throws IOException {
        System.out.print("Book title containing given string: ");
        String input = reader.readLine();

        List<Book> books = this.bookService.findAllByTitleContaining(input);

        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    private void task_8() throws IOException {
        System.out.print("Books, by Authors with last name starting with a given string: ");
        String input = reader.readLine();

        List<Book> books = this.bookService.findAllBooksByAuthorLastNameStartsWith(input);

        for (Book book : books) {
            System.out.printf("%s (%s %s)%n",
                    book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName());
        }
    }

    private void task_9() throws IOException {
        System.out.print("Books, title length: ");
        int input = Integer.parseInt(reader.readLine());

        long books = this.bookService.countBooksByTitleLength(input);

        System.out.println(books);
    }

    private void task_10() throws IOException {
        List<Long> counts = this.bookService.getCountByAuthorFullName();

        for (Long num : counts) {
            System.out.println(num);
        }
    }

    private void task_11() throws IOException {
        System.out.print("Get book, by title: ");
        String input = reader.readLine();

        Book book = this.bookService.getBookByTitle(input);

        System.out.printf("%s %s %s %.2f%n", book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice());
    }

    private void task_12() throws IOException {
        System.out.print("Enter the date (dd MMM yyyy) for the books: ");
        String date = reader.readLine();

        System.out.print("Enter the to number of copies to increase: ");
        int copies = Integer.parseInt(reader.readLine());

        LocalDate dateFormatted = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd MMM yyyy"));

        long count = this.bookService.increaseCopiesReleasedAfterDate(copies, dateFormatted);

        System.out.println(count);
    }

    private void task_13() throws IOException {
        System.out.print("Delete books, with less copies than: ");
        int copies = Integer.parseInt(reader.readLine());

        int count = this.bookService.deleteBooksByCopiesLowerThan(copies);

        System.out.println(count);
    }

    private void task_14() throws IOException {
        System.out.print("Enter author first and last time, to get the total books by them: ");
        String[] names = reader.readLine().split("\\s+");

        int count = this.authorService.countTotalBooksByAuthor(names[0], names[1]);

        System.out.println(count);
    }
}