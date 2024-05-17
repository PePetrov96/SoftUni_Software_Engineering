package com.resellerapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "seller")
    private List<Offer> offers = new ArrayList<>();

    @OneToMany(mappedBy = "buyer")
    private List<Offer> boughtOffers = new ArrayList<>();
}
