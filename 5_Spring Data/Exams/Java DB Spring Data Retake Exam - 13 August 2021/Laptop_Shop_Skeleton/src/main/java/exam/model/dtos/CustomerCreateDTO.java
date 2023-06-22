package exam.model.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateDTO {
    @Expose
    @Size(min = 2)
    private String firstName; //length value higher than or equal to 2

    @Expose
    @Size(min = 2)
    private String lastName; //length value higher than or equal to 2

    @Expose
    @Email
    private String email; //valid email addresses (must contains '@' and '.' – a dot)

    @Expose
    private String registeredOn;

    @Expose
    private CustomerTownCreateDTO town;
}
