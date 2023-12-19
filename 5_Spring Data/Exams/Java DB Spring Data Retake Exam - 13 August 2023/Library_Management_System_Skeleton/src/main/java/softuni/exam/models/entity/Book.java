package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.enums.Genre;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity{
    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "available", nullable = false)
    private boolean available;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private Genre genre;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @OneToMany(mappedBy = "book")
    private Set<BorrowingRecord> borrowingRecords;
}
