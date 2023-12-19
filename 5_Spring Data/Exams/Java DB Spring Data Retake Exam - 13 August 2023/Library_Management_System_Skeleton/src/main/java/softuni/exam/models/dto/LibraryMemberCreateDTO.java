package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class LibraryMemberCreateDTO implements Serializable {
    @Expose
    @Size(min = 2, max = 40)
    private String address;
    //accepts char sequence (between 2 to 40 inclusive). Can be nullable.

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;
    //first name - accepts char sequence (between 2 to 30 inclusive).

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;
    //last name - accepts char sequence (between 2 to 30 inclusive).

    @Expose
    @NotNull
    @Size(min = 2, max = 20)
    private String phoneNumber;
    //accepts char sequence (between 2 to 20 inclusive)
}
