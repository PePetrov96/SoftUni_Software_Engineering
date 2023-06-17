package com.example.football.models.dto.team;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamCreateDTO {
    @Expose
    @Size(min = 3)
    private String name;

    @Expose
    @Size(min = 3)
    private String stadiumName;

    @Expose
    @Min(value = 1000)
    private Integer fanBase;

    @Expose
    @Size(min = 10)
    private String history;

    @Expose
    private String townName;
}
