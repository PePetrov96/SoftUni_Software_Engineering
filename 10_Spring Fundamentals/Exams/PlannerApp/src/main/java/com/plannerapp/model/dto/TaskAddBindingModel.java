package com.plannerapp.model.dto;

import com.plannerapp.vallidation.FutureDateOnly;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class TaskAddBindingModel {
    @NotNull
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @NotNull
    @FutureDateOnly
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotEmpty(message = "You must select a priority!")
    private String priority;
}
