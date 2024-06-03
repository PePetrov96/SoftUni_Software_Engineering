package com.project.spring.service.impl;

import com.project.spring.model.dto.AuthorDTO;
import com.project.spring.model.dto.BookDTO;
import com.project.spring.model.entity.Author;
import com.project.spring.model.entity.Book;
import com.project.spring.repository.AuthorRepository;
import com.project.spring.repository.BookRepository;
import com.project.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return this.bookRepository
                .findAll()
                .stream()
                .map(BookServiceImpl::mapBookToDTO)
                .toList();
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return this.bookRepository
                .findById(id)
                .map(BookServiceImpl::mapBookToDTO);
    }

    @Override
    public void deleteBookByID(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        Author author = this.authorRepository
                .findAuthorByName(bookDTO.getAuthorDTO().getName())
                .orElse(null);

        if (author == null) {
            author = new Author();
            author.setName(bookDTO.getAuthorDTO().getName());

            author = this.authorRepository.saveAndFlush(author);
        }

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setAuthor(author);

        return this.bookRepository.save(book).getId();
    }

    private static BookDTO mapBookToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setIsbn(book.getIsbn());

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(book.getAuthor().getId());
        authorDTO.setName(book.getAuthor().getName());

        bookDTO.setAuthorDTO(authorDTO);

        return bookDTO;
    }
}
