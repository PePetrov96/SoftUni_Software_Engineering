package com.project.spring.models.dto;

import com.google.gson.annotations.Expose;
import com.project.spring.models.entity.Brand;
import com.project.spring.models.entity.enums.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ModelDTO extends BaseDTO {
    @Expose
    @Size(min = 2, message = "Name must be minimum two characters!")
    private String name;

    @Expose
    private String category;

    @Expose
    @Size(min = 8, max = 512, message = "Name must be minimum two characters!")
    private String imageUrl;

    @Expose
    private Integer startYear;

    @Expose
    private Integer endYear;

    @Expose
    private String created;

    @Expose
    private String modified;

    @Expose
    private String brand;
}
