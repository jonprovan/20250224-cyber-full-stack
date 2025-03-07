package com.skillstorm.food.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.food.dtos.CategoryDTO;
import com.skillstorm.food.models.Category;
import com.skillstorm.food.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<Category>> findAll(String startsWith) { 
		
		Iterable<Category> categories;
		
		try {
			if (startsWith == null)
				categories = repo.findAll();
			else
				categories = repo.findByCategoryNameStartingWith(startsWith);
			
			if (!categories.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categories);
			} else {
				return ResponseEntity.ok(categories);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// find by id
	public ResponseEntity<Category> findById(int id) {
		Optional<Category> category = repo.findById(id);
		
		try {
			if (category.isEmpty())
				return ResponseEntity.notFound().build();
			
			return ResponseEntity.ok(category.get());
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
		
	}
	
	// create one
	public ResponseEntity<Category> createOne(CategoryDTO dto) {
		try {
			 return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(new Category(0, dto.categoryName(), dto.recipes())));
			 
			 // REST standards say you should return a location for the newly-created record
			 // since you don't know the id beforehand, you won't necessarily know where to find it
			 // you can build and insert the location like this
			 // should really be assembled from property values rather than hardcoding the base URL
//			 Category saved = repo.save(new Category(0, dto.categoryName()));
//			 return ResponseEntity.created(new URI("localhost:8080/category/" + saved.getId())).body(saved);
			 
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// update one
	public ResponseEntity<Category> updateOne(int id, CategoryDTO dto) { 
		try {
			if (repo.existsById(id))
				return ResponseEntity.ok(repo.save(new Category(id, dto.categoryName(), dto.recipes())));
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
