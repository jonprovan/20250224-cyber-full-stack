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

import com.skillstorm.food.dtos.BioDTO;
import com.skillstorm.food.dtos.CategoryDTO;
import com.skillstorm.food.models.Bio;
import com.skillstorm.food.models.Category;
import com.skillstorm.food.services.BioService;
import com.skillstorm.food.services.CategoryService;

@RestController
@RequestMapping("/bio")
public class BioController {
	
	private BioService service;
	
	public BioController(BioService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Bio>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll(startsWith);
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Bio> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Bio> createOne(@RequestBody BioDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Bio> updateOne(@PathVariable int id, @RequestBody BioDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}
