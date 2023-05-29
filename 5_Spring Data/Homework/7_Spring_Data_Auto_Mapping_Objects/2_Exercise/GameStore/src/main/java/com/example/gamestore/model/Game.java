package com.example.gamestore.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "trailer")
    private String trailer;
    @Column(name = "image_thumbnail")
    private String imageThumbnail;
    @Column(name = "size")
    private BigDecimal size;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Game() {
    }

    public Game(String title, String trailer, String imageThumbnail,
                BigDecimal size, BigDecimal price, String description, LocalDate releaseDate) {
        setTitle(title);
        setTrailer(trailer);
        setImageThumbnail(imageThumbnail);
        setSize(size);
        setPrice(price);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    public Game(String title, BigDecimal price, String description, LocalDate releaseDate) {
        setTitle(title);
        setPrice(price);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Game other = (Game) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length() < 3 || title.length() > 100 || !title.matches("^[A-Z][a-z]+")) {
            throw new IllegalArgumentException("Invalid game title");
        }
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        if (trailer.length() != 11) {
            throw new IllegalArgumentException("Invalid trailer URL");
        }
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        if (!imageThumbnail.matches("^https://.*$|^http://.*$")) {
            throw new IllegalArgumentException("Invalid image URL");
        }
        this.imageThumbnail = imageThumbnail;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        if (size.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Size must be positive number");
        }
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be positive number");
        }
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length() < 20) {
            throw new IllegalArgumentException("Description length it too short");
        }
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}