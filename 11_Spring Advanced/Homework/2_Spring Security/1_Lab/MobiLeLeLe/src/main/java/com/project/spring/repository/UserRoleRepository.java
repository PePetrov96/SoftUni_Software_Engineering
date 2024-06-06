package com.project.spring.repository;

import com.project.spring.models.entity.UserRoleEntity;
import com.project.spring.models.entity.enums.UserRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findUserRoleByRole(UserRolesEnum userRolesEnum);
}
