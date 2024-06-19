package com.bonappetit.model.dto;

import com.bonappetit.vallidation.PasswordMatches;
import com.bonappetit.vallidation.UniqueEmail;
import com.bonappetit.vallidation.UniqueUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor
@PasswordMatches
public class UserRegisterDTO {
    @UniqueUsername
    @NotNull
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @UniqueEmail
    @NotEmpty(message = "Email cannot me empty!")
    @Email(message = "Must be a valid email address!")
    private String email;

    @NotNull
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotEmpty(message = "")
    private String confirmPassword;
}
