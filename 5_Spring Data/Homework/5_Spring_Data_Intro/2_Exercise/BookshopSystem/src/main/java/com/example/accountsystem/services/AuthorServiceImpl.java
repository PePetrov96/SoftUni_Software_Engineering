package com.example.accountsystem.services;

import com.example.accountsystem.model.Author;
import com.example.accountsystem.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public void registerAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author getRandomAuthor() {
        List<Author> authors = authorRepository.findAll();
        int randomIndex = new Random().nextInt(authors.size());
        return authors.get(randomIndex);
    }
}