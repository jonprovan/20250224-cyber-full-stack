package com.skillstorm.food.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.food.dtos.RecipeIngredientDTO;
import com.skillstorm.food.dtos.RecipeWithIngredientsDTO;
import com.skillstorm.food.models.Recipe;
import com.skillstorm.food.repositories.RecipeRepository;

@Service
public class RecipeService {
	
	@Value("${base-url}")
	private String baseURL;
	
	private RecipeRepository repo;
	
	public RecipeService(RecipeRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<Recipe>> findAll(String startsWith) { 
		
		Iterable<Recipe> recipes;
		
		try {
			if (startsWith == null)
				recipes = repo.findAll();
			else
				recipes = repo.findByRecipeNameStartingWith(startsWith);
			
			if (!recipes.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(recipes);
			} else {
				return ResponseEntity.ok(recipes);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// find by id
	public ResponseEntity<Recipe> findById(int id) {
		Optional<Recipe> recipe = repo.findById(id);
		
		try {
			if (recipe.isEmpty())
				return ResponseEntity.notFound().build();
			
			return ResponseEntity.ok(recipe.get());
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
		
	}
	
	// create one
	public ResponseEntity<Recipe> createOne(RecipeWithIngredientsDTO dto) {
		try {
			 Recipe saved = repo.save(new Recipe(0, dto.recipe().recipeName(), dto.recipe().recipeDescription(), 
					 								dto.recipe().cook(), dto.recipe().categories(), null));
			 if (dto.ingredients() != null)
				 for (RecipeIngredientDTO recipeIngredientDTO : dto.ingredients())
					 repo.addRecipeIngredient(saved.getId(), recipeIngredientDTO.id(), recipeIngredientDTO.amount());
			 return ResponseEntity.created(new URI(this.baseURL + "recipe/" + saved.getId())).body(repo.findById(saved.getId()).get());
			 
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// update one
	public ResponseEntity<Recipe> updateOne(int id, RecipeWithIngredientsDTO dto) { 
		try {
			if (repo.existsById(id)) {
				repo.save(new Recipe(id, dto.recipe().recipeName(), dto.recipe().recipeDescription(), 
									 dto.recipe().cook(), dto.recipe().categories(), null));
				if (dto.ingredients() != null)
					 for (RecipeIngredientDTO recipeIngredientDTO : dto.ingredients())
						 repo.addRecipeIngredient(id, recipeIngredientDTO.id(), recipeIngredientDTO.amount());
				return ResponseEntity.ok(repo.findById(id).get());
			}
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// delete one
	public ResponseEntity<Void> deleteById(int id) {
		try {
			repo.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

}
