package com.project.spring.models.entity;

import com.project.spring.models.entity.enums.UserRolesEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter @Setter @NoArgsConstructor
public class UserRoleEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRolesEnum role;
}
