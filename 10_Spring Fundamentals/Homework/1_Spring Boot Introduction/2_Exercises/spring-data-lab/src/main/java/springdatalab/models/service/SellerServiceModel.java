package springdatalab.models.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SellerServiceModel {
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "First name must be more than two characters!")
    private String firstName;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Last name must be more than two characters!")
    private String lastName;

    private Integer age;

    private BigDecimal salary;

    private String manager;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Shop name must be more than two characters!")
    private String shop;
}
