package com.resellerapp.repository;

import com.resellerapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.offers WHERE u.id = (:id)")
    Optional<User> findByIdAndFetchOffersEagerly(@Param("id") Long id);
}
