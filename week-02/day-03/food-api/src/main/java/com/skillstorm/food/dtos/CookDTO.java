package com.skillstorm.food.dtos;

import java.util.List;

import com.skillstorm.food.models.Bio;
import com.skillstorm.food.models.Recipe;

public record CookDTO(String firstName, String lastName, Bio bio, List<Recipe> recipes) {}
