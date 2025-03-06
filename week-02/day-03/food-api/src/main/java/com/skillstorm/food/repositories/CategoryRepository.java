package com.skillstorm.food.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	// this custom method uses the Spring Data JPA API
	// the naming of the method dictates what it will do
	// we DO NOT need the @Query annotation, because we're not providing our own custom query string
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	Iterable<Category> findByCategoryNameStartingWith(String startsWith);

}
