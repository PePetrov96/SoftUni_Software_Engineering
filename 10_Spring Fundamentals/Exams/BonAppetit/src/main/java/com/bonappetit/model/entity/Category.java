package com.bonappetit.model.entity;

import com.bonappetit.model.entity.enums.CategoryName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    @Column(name = "category_name")
    private CategoryName categoryName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    @PrePersist
    public void setDescription() {
        this.description = this.categoryName.getDescription();
    }
}