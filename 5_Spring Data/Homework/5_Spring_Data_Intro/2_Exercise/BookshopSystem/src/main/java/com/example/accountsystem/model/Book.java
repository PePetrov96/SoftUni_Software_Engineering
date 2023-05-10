package com.example.accountsystem.model;

import com.example.accountsystem.enums.AgeRestriction;
import com.example.accountsystem.enums.EditionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "edition_type", nullable = false, columnDefinition = "VARCHAR(6)")
    private String editionType; //NORMAL, PROMO, GOLD
    @Column(name = "price", nullable = false, columnDefinition = "DECIMAL(5,2)")
    private BigDecimal price;
    @Column(name = "copies", nullable = false, columnDefinition = "INT")
    private long copies;
    @Column(name = "release_date", columnDefinition = "DATE")
    private Date releaseDate;
    @Column(name = "age_restriction", nullable = false, columnDefinition = "VARCHAR(5)")
    private String ageRestriction; //MINOR, TEEN, ADULT
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToMany
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    public Book() {
        categories = new HashSet<>();
    }

    public Book(String title, EditionType editionType, String date, BigDecimal price, long copies, AgeRestriction ageRestriction, Author author, Category category) {
        this();

        setTitle(title);
        setEditionType(editionType);
        setReleaseDate(date);
        setPrice(price);
        setCopies(copies);
        setAgeRestriction(ageRestriction);
        setAuthor(author);
        addCategory(category);
    }

    public Book(String title, String description, EditionType editionType, BigDecimal price,
                long copies, String releaseDate, AgeRestriction ageRestriction, Author author) {
        this();

        setTitle(title);
        setDescription(description);
        setEditionType(editionType);
        setPrice(price);
        setCopies(copies);
        setReleaseDate(releaseDate);
        setAgeRestriction(ageRestriction);
        setAuthor(author);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType.name();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getCopies() {
        return copies;
    }

    public void setCopies(long copies) {
        this.copies = copies;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputDateFormat.setTimeZone(TimeZone.getTimeZone("Etc/GMT+2"));

        Date inputDate;

        try {
            inputDate = inputDateFormat.parse(releaseDate);
        } catch (ParseException e) {
            throw new RuntimeException("Date format is wrong, please use - DD/MM/YYYY");
        }

        this.releaseDate = new java.sql.Date(inputDate.getTime());
    }


    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction.name();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        author.addBook(this);
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
        category.addBook(this);
    }
    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.addBook(this);
    }
}