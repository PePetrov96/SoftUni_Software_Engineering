package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookCreateDTO;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.Paths.BOOKS_PATH;
import static softuni.exam.constants.Messages.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final Gson gson;
    private final ValidationUtils validator;
    private final ModelMapper mapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, Gson gson,
                           ValidationUtils validator, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder out = new StringBuilder();

        BookCreateDTO[] bookDTOs = this.gson.fromJson(readBooksFromFile(), BookCreateDTO[].class);

        for (BookCreateDTO bookDTO : bookDTOs) {
            boolean isValid = this.validator.isValid(bookDTO);

            if (BookExists(bookDTO)) {
                isValid = false;
            }

            if (isValid) {
                out.append(String.format(BOOK_IMPORTED,
                        bookDTO.getAuthor(),
                        bookDTO.getTitle()));

                Book book = this.mapper.map(bookDTO, Book.class);

                this.bookRepository.saveAndFlush(book);
            } else {
                out.append(INVALID_BOOK);
            }

            out.append(System.lineSeparator());
        }

        return out.toString().trim();
    }

    private boolean BookExists(BookCreateDTO bookDTO) {
        return this.bookRepository
                .findBookByTitle(bookDTO.getTitle())
                .isPresent();
    }
}
