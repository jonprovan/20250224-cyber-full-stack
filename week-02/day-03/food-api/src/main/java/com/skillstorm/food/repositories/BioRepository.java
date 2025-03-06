package com.skillstorm.food.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Bio;

@Repository
public interface BioRepository extends CrudRepository<Bio, Integer> {
	
	Iterable<Bio> findByCookDescriptionStartingWith(String startsWith);

}
