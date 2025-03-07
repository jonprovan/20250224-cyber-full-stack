package com.skillstorm.food.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Cook;

@Repository
public interface CookRepository extends CrudRepository<Cook, Integer> {
	
	Iterable<Cook> findByFirstNameStartingWith(String startsWith);

}
