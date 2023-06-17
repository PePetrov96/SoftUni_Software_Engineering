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
@Table(name = "stats")
public class Stat extends BaseEntity {
    @Column(name = "shooting", nullable = false)
    private Double shooting;

    @Column(name = "passing", nullable = false)
    private Double passing;

    @Column(name = "endurance", nullable = false)
    private Double endurance;
}
