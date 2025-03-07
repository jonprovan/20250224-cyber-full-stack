package com.skillstorm.food.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.food.dtos.CookDTO;
import com.skillstorm.food.models.Cook;
import com.skillstorm.food.repositories.CookRepository;

@Service
public class CookService {
	
	@Value("${base-url}")
	private String baseURL;
	
	private CookRepository repo;
	
	public CookService(CookRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<Cook>> findAll(String startsWith) { 
		
		Iterable<Cook> cooks;
		
		try {
			if (startsWith == null)
				cooks = repo.findAll();
			else
				cooks = repo.findByFirstNameStartingWith(startsWith);
			
			if (!cooks.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cooks);
			} else {
				return ResponseEntity.ok(cooks);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// find by id
	public ResponseEntity<Cook> findById(int id) {
		Optional<Cook> cook = repo.findById(id);
		
		try {
			if (cook.isEmpty())
				return ResponseEntity.notFound().build();
			
			return ResponseEntity.ok(cook.get());
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
		
	}
	
	// create one
	public ResponseEntity<Cook> createOne(CookDTO dto) {
		try {
			 Cook saved = repo.save(new Cook(0, dto.firstName(), dto.lastName(), dto.bio()));
			 return ResponseEntity.created(new URI(this.baseURL + "cook/" + saved.getId())).body(saved);
			 
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// update one
	public ResponseEntity<Cook> updateOne(int id, CookDTO dto) { 
		try {
			if (repo.existsById(id))
				return ResponseEntity.ok(repo.save(new Cook(id, dto.firstName(), dto.lastName(), dto.bio())));
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
