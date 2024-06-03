package com.project.spring.init;

import com.project.spring.model.entity.Author;
import com.project.spring.model.entity.Book;
import com.project.spring.repository.AuthorRepository;
import com.project.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitialization implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public DatabaseInitialization(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorRepository.count() == 0) {
            initializeAuthors();
        }

        if (this.bookRepository.count() == 0) {
            initializeBooks();
        }
    }

    private void initializeBooks() {
        Book book1 = new Book();
        book1.setTitle("Pod Igoto");
        book1.setAuthor(this.authorRepository.findByName("Ivan Vazov"));
        book1.setIsbn("0000-3333-2222-4444");
        this.bookRepository.saveAndFlush(book1);

        Book book2 = new Book();
        book2.setTitle("Na nivata");
        book2.setAuthor(this.authorRepository.findByName("Peyo Yavorov"));
        book2.setIsbn("0000-6666-2222-5555");
        this.bookRepository.saveAndFlush(book2);

        Book book3 = new Book();
        book3.setTitle("Bai Ganyo");
        book3.setAuthor(this.authorRepository.findByName("Aleko Konstantinov"));
        book3.setIsbn("0000-1111-2222-3333");
        this.bookRepository.saveAndFlush(book3);
    }

    private void initializeAuthors() {
        Author author1 = new Author();
        author1.setName("Ivan Vazov");
        this.authorRepository.saveAndFlush(author1);

        Author author2 = new Author();
        author2.setName("Peyo Yavorov");
        this.authorRepository.saveAndFlush(author2);

        Author author3 = new Author();
        author3.setName("Aleko Konstantinov");
        this.authorRepository.saveAndFlush(author3);
    }
}
