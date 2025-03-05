package com.skillstorm.food.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.food.dtos.IngredientDTO;
import com.skillstorm.food.models.Ingredient;
import com.skillstorm.food.repositories.IngredientRepository;

/*
 * a Service class is where you'll put all the logic for processing requests
 * it will reach out to our repo to execute DB requests
 * as such, we have to inject the repo here
 * 
 * the @Service annotation makes this a discoverable and injectable component
 */

@Service
public class IngredientService {
	
	private IngredientRepository repo;
	
	// three ways to inject a dependent class/interface
	
	// OPTION 1: Autowired
	// this annotation will automatically fill this variable with an injected instance of the associated repo
	// this only works if we have one and only one Bean returning type IngredientRepository
	// doesn't work great for testing due to unavailable dependencies
//	@Autowired
//	private IngredientRepository repo;
	
	// OPTION 2: Setter Injection
	// if we Autowire a setter, it will run on instantiation and fill the variable with the injected Bean
//	@Autowired
//	public void setRepo(IngredientRepository repo) {
//		this.repo = repo;
//	}
	
	// OPTION 3: Constructor Injection (PREFERRED)
	// the constructor does NOT need the Autowired annotation
	// BUT, if it's the ONLY constructor and takes in a Bean, it will grab it from the context, like the setter
	public IngredientService(IngredientRepository repo) {
		this.repo = repo;
	}
	
	// find all
	// we want to return a ResponseEntity, so we have control over the status code, headers, etc.
	// ResponseEntity uses a builder pattern to assemble an HttpResponse
	// it automatically returns an HttpErrorResponse if we use a 400/500-level status code
	public ResponseEntity<Iterable<Ingredient>> findAll() { 
		
		Iterable<Ingredient> ingredients = repo.findAll();
		if (!ingredients.iterator().hasNext())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ingredients);
		else
			return ResponseEntity.status(HttpStatus.OK).body(ingredients);
	}
	
	// find by id
	// this takes in an id from the controller
	// since repo.findById returns an optional, we have to check first if the object actually exists before deciding on a response
	public ResponseEntity<Ingredient> findById(int id) {
		Optional<Ingredient> ingredient = repo.findById(id);
		
		if (ingredient.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		else
			return ResponseEntity.status(HttpStatus.OK).body(ingredient.get());
	}
	
	// create one
	// this takes in our DTO, because we don't want the user sending an id
	// also, the repo.save() method IS BOTH CREATE AND UPDATE!!
	// if we include an existing id, it will update it
	// if we include a non-existing id, it will ignore the id and create a new record
	public ResponseEntity<Ingredient> createOne(IngredientDTO ingredientDTO) { 
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(repo.save(new Ingredient(0, ingredientDTO.ingredientName(), ingredientDTO.ingredientType())));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	
	
	
	
	
	

}
