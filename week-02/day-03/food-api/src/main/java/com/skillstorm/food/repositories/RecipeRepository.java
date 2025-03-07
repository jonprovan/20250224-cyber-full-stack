package com.skillstorm.food.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Recipe;

import jakarta.transaction.Transactional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
	
	Iterable<Recipe> findByRecipeNameStartingWith(String startsWith);
	
	// @Modifying and @Transactional are required for non-select statements to the database
	@Query(value = "INSERT INTO recipe_ingredient(recipe_id, ingredient_id, amount) VALUES(?1, ?2, ?3)", nativeQuery = true)
	@Modifying
	@Transactional
	void addRecipeIngredient(int recipeId, int ingredientId, String amount);
	
}
