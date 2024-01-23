package com.project.spring.models.dto;

import com.project.spring.models.entity.UserRole;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private boolean isActive;

    @NotNull
    @NotEmpty
    private UserRole role;

    @NotNull
    @NotEmpty
    private String imageUrl;

    @NotNull
    @NotEmpty
    private LocalDateTime created;

    @NotNull
    @NotEmpty
    private LocalDateTime modified;
}
