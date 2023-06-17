package com.example.football.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "population", nullable = false)
    private Integer population;

    @Column(name = "travel_guide", nullable = false, columnDefinition = "TEXT")
    private String travelGuide;
}
