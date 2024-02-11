package com.project.spring.models.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Empty;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    @NotEmpty(message = "usernameEmpty")
    private String username;

    @NotEmpty(message = "passwordEmpty")
    private String password;

    @NotEmpty(message = "firstNameEmpty")
    private String firstName;

    @NotEmpty(message = "lastNameEmpty")
    private String lastName;

    private boolean isActive;

    @NotNull(message = "roleEmpty")
    private String role;

    private String imageUrl;
}
