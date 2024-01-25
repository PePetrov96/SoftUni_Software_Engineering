package com.project.spring.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO extends BaseDTO {
    @Expose
    @Size(min = 2, message = "Name must be minimum two characters!")
    private String name;
}
