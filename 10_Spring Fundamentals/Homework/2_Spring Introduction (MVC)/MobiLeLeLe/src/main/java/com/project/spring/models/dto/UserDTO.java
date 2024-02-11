package com.project.spring.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private boolean isActive;

    private String role;

    private String imageUrl;
}
