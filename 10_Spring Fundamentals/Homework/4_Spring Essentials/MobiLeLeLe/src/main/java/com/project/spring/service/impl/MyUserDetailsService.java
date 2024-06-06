package com.project.spring.service.impl;

import com.project.spring.models.entity.UserRoleEntity;
import com.project.spring.repository.UserRepository;
import com.project.spring.models.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByUsername(username)
                .map(userEntity -> {
                    System.out.println("User: " + userEntity.getUsername() + " has roles: " + userEntity.getRoles());
                    return map(userEntity);
                })
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found!"));
    }

    protected UserDetails map(UserEntity userEntity) {
        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity
                        .getRoles()
                        .stream()
                        .map(roleEntity -> {
                            GrantedAuthority authority = map(roleEntity);
                            System.out.println("Mapping authority: " + authority.getAuthority());
                            return authority;
                        })
                        .toList())
                .build();
    }

    private static GrantedAuthority map(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole());
    }
}
