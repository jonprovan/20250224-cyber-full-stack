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

import com.skillstorm.food.dtos.CategoryDTO;
import com.skillstorm.food.models.Category;
import com.skillstorm.food.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private CategoryService service;
	
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Category>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll(startsWith);
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Category> createOne(@RequestBody CategoryDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateOne(@PathVariable int id, @RequestBody CategoryDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}
