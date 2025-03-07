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

import com.skillstorm.food.dtos.CookDTO;
import com.skillstorm.food.models.Cook;
import com.skillstorm.food.services.CookService;

@RestController
@RequestMapping("/cook")
public class CookController {
	
	private CookService service;
	
	public CookController(CookService service) {
		this.service = service;
	}
	
	// find all
	@GetMapping
	public ResponseEntity<Iterable<Cook>> findAll(@RequestParam(required = false) String startsWith) {
		return service.findAll(startsWith);
	}
	
	// find by id
	@GetMapping("/{id}")
	public ResponseEntity<Cook> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	// create one
	@PostMapping
	public ResponseEntity<Cook> createOne(@RequestBody CookDTO dto) {
		return service.createOne(dto);
	}
	
	// update one
	@PutMapping("/{id}")
	public ResponseEntity<Cook> updateOne(@PathVariable int id, @RequestBody CookDTO dto) {
		return service.updateOne(id, dto);
	}
	
	// delete one
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}
