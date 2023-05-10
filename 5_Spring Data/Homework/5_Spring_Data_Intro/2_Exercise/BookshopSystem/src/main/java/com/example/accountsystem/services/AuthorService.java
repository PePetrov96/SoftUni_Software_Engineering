package com.example.accountsystem.services;

import com.example.accountsystem.model.Author;

public interface AuthorService {
    void registerAuthor(Author author);
    Author getRandomAuthor();
}