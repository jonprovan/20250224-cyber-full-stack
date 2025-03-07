package com.skillstorm.food.dtos;

import java.util.List;

import com.skillstorm.food.models.Category;
import com.skillstorm.food.models.Cook;
import com.skillstorm.food.models.Ingredient;

public record RecipeDTO(String recipeName, String recipeDescription, Cook cook, List<Category> categories, List<Ingredient> ingredients) {}
