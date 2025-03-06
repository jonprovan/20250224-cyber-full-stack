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

import com.skillstorm.food.dtos.IngredientDTO;
import com.skillstorm.food.models.Ingredient;
import com.skillstorm.food.services.IngredientService;

/*
 * a Controller class should NOT be confused with the "Controller" part of the MVC framework
 * a Controller class opens the application up to web requests from clients
 * it will make certain endpoints available, dictate what structure the requests must take, what they return, etc.
 * 
 * the @RestController annotation includes @Controller and @ResponseBody
 * @Controller makes this a component that's discoverable and provides public endpoints
 * @ResponseBody says that the response to each method is NOT a webpage but INSTEAD an HttpResponse
 * 
 * the @RequestMapping annotation sets up the first part of the post-domain URL for all methods in this class
 * we can also tack onto that for individual methods
 * 
 * our Controller requires our Service component to be injected
 */

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	// injecting our service like we did with our repository
	private IngredientService service;
	
	public IngredientController(IngredientService service) {
		this.service = service;
	}
	
	// here are our endpoints!
	
	// find all
	// this annotation marks this as a GET method
	// if we need an additional suffix, we can include it like @GetMapping("/suffix")
	// we're using an optional RequestParam (also referred to as a query parameter) to take in a string by which to filter
	// just like with PathVariables, if the RequestParam name and the variable name match, you don't need the 'name = "type"' part
	@GetMapping
	public ResponseEntity<Iterable<Ingredient>> findAll(@RequestParam(name = "type", required = false) String type) {
		return service.findAll(type);
	}
	
	// find by id
	// we use this syntax to set up a path variable that will get filled with whatever's in the URL at this spot
	// we also annotate the variable in the parameters with @PathVariable
	// if the parameter name matches the path variable name, you DO NOT need the ("idNumber") part after @PathVariable
	// if it DOES NOT match, you do
	@GetMapping("/{idNumber}")
	public ResponseEntity<Ingredient> findById(@PathVariable("idNumber") int id) {
		return service.findById(id);
	}
	
	// create one
	// even though this has the same endpoint suffix as our findAll() method, it's a different HTTP request type
	// to indicate a parameter is coming via the body, use @RequestBody
	// using our DTO so the user cannot include an id
	@PostMapping
	public ResponseEntity<Ingredient> createOne(@RequestBody IngredientDTO ingredientDTO) {
		return service.createOne(ingredientDTO);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Ingredient> updateOne(@PathVariable int id, @RequestBody IngredientDTO ingredientDTO) {
		return service.updateOne(id, ingredientDTO);
	}
	
	// delete one
	// delete methods return void and are "successful" whether there was a record at that id or not
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	
	
	
	
	

}
