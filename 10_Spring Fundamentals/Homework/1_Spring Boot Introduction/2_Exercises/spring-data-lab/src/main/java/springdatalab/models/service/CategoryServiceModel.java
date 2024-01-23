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
public class CategoryServiceModel {
    private String id;

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name must be minimum two characters!")
    private String name;
}
