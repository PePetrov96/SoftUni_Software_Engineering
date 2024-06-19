package com.bonappetit.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
@Getter
@Setter
@NoArgsConstructor
public class Recipe extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "ingredients")
    private String ingredients ;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User addedBy;

    @ManyToMany(mappedBy = "favouriteRecipes", fetch = FetchType.EAGER)
    private Set<User> markedByUsers = new HashSet<>();
}