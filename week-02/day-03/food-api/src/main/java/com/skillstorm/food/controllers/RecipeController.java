package com.skillstorm.food.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.food.dtos.RecipeWithIngredientsDTO;
import com.skillstorm.food.models.Recipe;
import com.skillstorm.food.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
	
	private RecipeService service;
	
	public RecipeController(RecipeService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Recipe>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll(startsWith);
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Recipe> createOne(@RequestBody RecipeWithIngredientsDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Recipe> updateOne(@PathVariable int id, @RequestBody RecipeWithIngredientsDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}
