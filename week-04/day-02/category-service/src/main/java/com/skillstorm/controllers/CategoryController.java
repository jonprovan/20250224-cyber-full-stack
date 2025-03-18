package com.skillstorm.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.skillstorm.models.Category;
import com.skillstorm.models.Vehicle;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private Category muscleCar = new Category("MuscleCar", new HashSet<>(Arrays.asList("Charger R/T", "GTO 500")));
	private Category exotic = new Category("Exotic", new HashSet<>(Arrays.asList("Gallardo")));
	private Category compact = new Category("Compact", new HashSet<>(Arrays.asList("Civic")));
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok(new LinkedList<>(Arrays.asList(muscleCar, exotic, compact)));
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Vehicle[]> getVehiclesByCategory(@PathVariable String name) {
		
		// to make a request to another API, you can use RestTemplate
		// within a microservices architecture, there's a better way to do this, since we won't know the locations of other services
		// but for external API requests, this is how you do it
		RestTemplate rt = new RestTemplate();
		
		// if we need headers, we can create them, then add them
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		// holding our body here temporarily
		Set<String> body = null;
		List<Category> categories = new LinkedList<>(Arrays.asList(muscleCar, exotic, compact));
		for (Category category : categories)
			if (name.equals(category.name()))
				body = category.models();
		
		// now that we have headers and a body, we pack them into an HttpEntity the RestTemplate can use
		// you can place a body, headers, or both in here
		HttpEntity<Set<String>> entity = new HttpEntity<>(body, headers);
		
		// executing the RestTemplate call to the other service
		// parameters = (URL to hit, HTTP method, entity with body and/or headers, class for what's returned)
		return rt.exchange("http://localhost:8081/vehicle/bycategory", HttpMethod.POST, entity, Vehicle[].class);
		
	}

}
