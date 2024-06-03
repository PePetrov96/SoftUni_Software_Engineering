package com.project.spring.service;

import com.project.spring.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> getAllBooks();
    Optional<BookDTO> getBookById(Long id);
    Long createBook(BookDTO bookDTO);
    void deleteBookByID(Long id);
}
