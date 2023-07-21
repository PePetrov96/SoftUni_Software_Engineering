package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MechanicCreateDTO {
    @Expose
    @NotNull
    @Size(min = 2)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2)
    private String lastName;

    @Expose
    @NotNull
    @Email
    private String email;

    @Expose
    @NotNull
    @Size(min = 2)
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}