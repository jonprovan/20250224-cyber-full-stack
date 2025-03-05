package com.skillstorm.food.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Ingredient;

/*
 * A repository interface will automatically provide a host of pre-baked methods we can use to interact with the corresponding table
 * We DO NOT need to spell these out BUT we can create custom methods as needed
 * 
 * This is a Component/Bean that we can inject elsewhere
 * The @Repository annotation sets this up as an injectable repo AND allows @ComponentScan to find it
 * We extend an existing repo type and provide this interface with a model type and the type of its primary key
 */

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
	
}
