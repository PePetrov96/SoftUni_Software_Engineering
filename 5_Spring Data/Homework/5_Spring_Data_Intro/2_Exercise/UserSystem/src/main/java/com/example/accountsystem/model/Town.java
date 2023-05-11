package com.example.accountsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "bornTown", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> bornTownUsers;

    @OneToMany(mappedBy = "livingInTown", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> livingInTownUsers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Town() {
        bornTownUsers = new ArrayList<>();
        livingInTownUsers = new ArrayList<>();
    }

    public Town(String name) {
        this();

        setName(name);
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

    public List<User> getBornTownUsers() {
        return bornTownUsers;
    }

    public void setBornTownUsers(List<User> bornTownUsers) {
        this.bornTownUsers = bornTownUsers;
    }

    public List<User> getLivingInTownUsers() {
        return livingInTownUsers;
    }

    public void setLivingInTownUsers(List<User> livingInTownUsers) {
        this.livingInTownUsers = livingInTownUsers;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
        country.addTown(this);
    }

    public void addBornTownUser(User user) {
        this.bornTownUsers.add(user);
    }

    public void removeBornTownUser(User user) {
        this.bornTownUsers.remove(user);
    }

    public void addLivingInTownUser(User user) {
        this.livingInTownUsers.add(user);
    }

    public void removeLivingInTownUser(User user) {
        this.livingInTownUsers.remove(user);
    }
}