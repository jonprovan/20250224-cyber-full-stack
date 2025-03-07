package com.skillstorm.food.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.food.dtos.BioDTO;
import com.skillstorm.food.models.Bio;
import com.skillstorm.food.repositories.BioRepository;

@Service
public class BioService {
	
	// this annotation and syntax grabs a value from our application.yml file
	@Value("${base-url}")
	private String baseURL;
	
	private BioRepository repo;
	
	public BioService(BioRepository repo) {
		this.repo = repo;
	}
	
	// find all
	public ResponseEntity<Iterable<Bio>> findAll(String startsWith) { 
		
		Iterable<Bio> bios;
		
		try {
			if (startsWith == null)
				bios = repo.findAll();
			else
				bios = repo.findByCookDescriptionStartingWith(startsWith);
			
			if (!bios.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(bios);
			} else {
				return ResponseEntity.ok(bios);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// find by id
	public ResponseEntity<Bio> findById(int id) {
		Optional<Bio> bio = repo.findById(id);
		
		try {
			if (bio.isEmpty())
				return ResponseEntity.notFound().build();
			
			return ResponseEntity.ok(bio.get());
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
		
	}
	
	// create one
	public ResponseEntity<Bio> createOne(BioDTO dto) {
		try {
			 Bio saved = repo.save(new Bio(0, dto.cookDescription(), dto.cook()));
			 return ResponseEntity.created(new URI(this.baseURL + "bio/" + saved.getId())).body(saved);
			 
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	// update one
	public ResponseEntity<Bio> updateOne(int id, BioDTO dto) { 
		try {
			if (repo.existsById(id))
				return ResponseEntity.ok(repo.save(new Bio(id, dto.cookDescription(), dto.cook())));
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
