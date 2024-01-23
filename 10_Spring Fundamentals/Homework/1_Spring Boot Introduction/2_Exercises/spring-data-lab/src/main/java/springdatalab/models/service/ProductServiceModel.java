package springdatalab.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductServiceModel {
    private String id;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name length must be more than two characters!")
    private String name;

    @DecimalMin(value = "0")
    private BigDecimal price;

    private String description;

    private LocalDate bestBefore;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Category name length must be more than two characters!")
    private String category;

    private List<String> shopNames;
}