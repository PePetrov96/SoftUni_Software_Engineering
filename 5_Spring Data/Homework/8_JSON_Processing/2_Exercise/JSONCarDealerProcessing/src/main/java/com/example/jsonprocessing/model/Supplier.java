package com.example.jsonprocessing.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier")
    private List<Part> parts = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(String name, boolean isImported) {
        this.name = name;
        this.isImporter = isImported;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void addPart(Part part) {
        this.parts.add(part);
    }
    public void removePart(Part part) {
        this.parts.remove(part);
    }
}