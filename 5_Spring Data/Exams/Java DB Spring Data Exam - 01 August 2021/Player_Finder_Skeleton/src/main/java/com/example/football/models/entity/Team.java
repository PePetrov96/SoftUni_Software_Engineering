package com.example.football.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "stadium_name", nullable = false)
    private String stadiumName;

    @Column(name = "fan_base", nullable = false)
    private Integer fanBase;

    @Column(name = "history", nullable = false, columnDefinition = "TEXT")
    private String history;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;
}
