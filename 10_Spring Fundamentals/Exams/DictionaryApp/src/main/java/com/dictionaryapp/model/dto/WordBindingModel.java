package com.dictionaryapp.model.dto;

import com.dictionaryapp.validation.PastOrPresentDateOnly;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class WordBindingModel {
    @NotNull
    @Size(min = 2, max = 50, message = "The term length must be between 2 and 40 characters!")
    private String term;

    @NotNull
    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 80 characters!")
    private String translation;

    @NotNull
    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")
    private String example;

    @PastOrPresentDateOnly
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputDate;

    @NotEmpty(message = "You must select a language!")
    private String language;
}
