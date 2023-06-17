package com.example.football.models.dto.town;

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
public class TownCreateDTO {
    @Expose
    @Size(min = 2)
    private String name;
    @Expose
    @Min(value = 1)
    private Integer population;
    @Expose
    @Size(min = 10)
    private String travelGuide;
}
