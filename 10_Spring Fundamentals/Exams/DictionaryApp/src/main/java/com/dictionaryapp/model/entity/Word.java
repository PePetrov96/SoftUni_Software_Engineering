package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "word")
@Getter @Setter @NoArgsConstructor
public class Word extends BaseEntity{
    @Column(name = "term", nullable = false, length = 40)
    private String term;

    @Column(name = "translation", nullable = false, length = 80)
    private String translation;

    @Column(name = "example", length = 200)
    private String example;

    @Column(name = "input_date", nullable = false)
    private LocalDate inputDate;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User addedBy;
}
