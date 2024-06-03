package com.project.spring.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter @NoArgsConstructor
public class Book extends BaseEntity {
    private String title;
    private String Isbn;

    @ManyToOne
    private Author author;

    public void setAuthor(Author author) {
        this.author = author;
        author.addBook(this);
    }
}
