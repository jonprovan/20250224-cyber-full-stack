package com.skillstorm.food.dtos;

import java.util.List;

public record RecipeWithIngredientsDTO(RecipeDTO recipe, List<RecipeIngredientDTO> ingredients) {}
