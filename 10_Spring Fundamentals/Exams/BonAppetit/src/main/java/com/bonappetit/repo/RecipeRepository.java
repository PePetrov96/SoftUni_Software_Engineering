package com.bonappetit.repo;


import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import com.bonappetit.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Set<Recipe> findAllByCategory_CategoryName(CategoryName categoryName);

    @Query("SELECT r FROM Recipe r WHERE :user MEMBER OF r.markedByUsers")
    Set<Recipe> findAllFavouritesByUser(@Param("user") User user);
}