package com.skillstorm.food.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.food.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
