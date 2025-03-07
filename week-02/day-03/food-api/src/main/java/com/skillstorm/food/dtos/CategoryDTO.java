package com.skillstorm.food.dtos;

import java.util.List;

import com.skillstorm.food.models.Recipe;

public record CategoryDTO(String categoryName, List<Recipe> recipes) {}
