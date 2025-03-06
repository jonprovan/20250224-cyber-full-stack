package com.skillstorm.food.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.food.models.Category;
import com.skillstorm.food.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	
	// find by id
	public ResponseEntity<Category> findById(int id) {
		Optional<Category> category = repo.findById(id);
		
		if (category.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(category.get());
		}
	}

}
