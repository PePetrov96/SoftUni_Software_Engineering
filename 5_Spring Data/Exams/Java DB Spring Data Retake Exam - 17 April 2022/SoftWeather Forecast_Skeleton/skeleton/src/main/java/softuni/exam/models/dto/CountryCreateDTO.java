package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CountryCreateDTO implements Serializable {
    @Expose
    @Size(min = 2, max = 60)
    private String countryName;
    @Expose
    @Size(min = 2, max = 20)
    private String currency;
}
