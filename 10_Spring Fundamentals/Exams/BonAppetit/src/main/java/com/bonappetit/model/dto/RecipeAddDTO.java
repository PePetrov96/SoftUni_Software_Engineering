package com.bonappetit.model.dto;

import com.bonappetit.model.entity.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor
public class RecipeAddDTO {
    @NotNull
    @Size(min = 2, max = 40, message = "Name length must be between 2 and 40 characters!")
    private String name;

    @NotNull
    @Size(min = 2, max = 40, message = "Ingredients length must be between 2 and 80 characters!")
    private String ingredients;

    @NotEmpty(message = "You must select a category!")
    private String category;
}
