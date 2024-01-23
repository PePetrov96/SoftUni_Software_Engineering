package springdatalab.models.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ShopServiceModel {
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name length must be more than two characters!")
    private String name;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Address length must be more than two characters!")
    private String address;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Town name length must be more than two characters!")
    private String town;
}
