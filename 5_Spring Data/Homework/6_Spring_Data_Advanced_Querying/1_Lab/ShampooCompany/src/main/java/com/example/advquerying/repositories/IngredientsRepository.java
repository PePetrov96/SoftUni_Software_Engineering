package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String startingLetters);
    List<Ingredient> findAllByNameIsInOrderByPrice(Collection<String> name);
    Set<Ingredient> findAllByNameIn(List<String> names);
    @Query(value = "SELECT s FROM Shampoo AS s JOIN s.ingredients AS i WHERE i IN :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);

    @Query(value = "SELECT s FROM Shampoo AS s WHERE SIZE(s.ingredients) < :count")
    List<Shampoo> findShampoosWithIngredientCountGreaterThan(@Param(value = "count") int count);

    @Modifying
    @Query(value = "DELETE FROM Ingredient AS i WHERE i.name = :ingredientName")
    void deleteIngredientByName(@Param(value = "ingredientName") String name);

    @Modifying
    @Query(value = "UPDATE Ingredient AS i SET i.price = i.price * 1.1")
    void increasePriceByTenPercent();

    @Modifying
    @Query(value = "UPDATE Ingredient AS i SET i.price = i.price * 1.1 WHERE i.name IN :ingredientNames")
    void increasePriceByTenPercentOfIngredientsIn(@Param(value = "ingredientNames") Set<String> name);
}