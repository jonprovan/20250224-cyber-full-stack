package com.skillstorm.food.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String recipeName;
	
	@Column
	private String recipeDescription;
	
	// from the controlling side, @ManyToOne looks just like @OneToOne
	@ManyToOne
	@JoinColumn(name = "cook", referencedColumnName = "id")
	@JsonIgnoreProperties("recipes")
	private Cook cook;
	
	// many-to-many is a little more complex, because we're using a join table between this class and another
	// within @JoinTable, name = the name of the join table, joinColumns = the name of the column linking to THIS table in the join table
	// inverseJoinColumns = the name of the column linking to the OTHER table in the join table
	@ManyToMany
	@JoinTable(name = "recipe_category",
			   joinColumns = @JoinColumn(name = "recipe_id"),
			   inverseJoinColumns = @JoinColumn(name = "category_id"))
	@JsonIgnoreProperties("recipes")
	private List<Category> categories;
	
	@ManyToMany
	@JoinTable(name = "recipe_ingredient",
			   joinColumns = @JoinColumn(name = "recipe_id"),
			   inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	@JsonIgnoreProperties("recipes")
	private List<Ingredient> ingredients;
	
	public Recipe() {
		super();
	}

	public Recipe(int id, String recipeName, String recipeDescription, Cook cook, List<Category> categories,
			List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.cook = cook;
		this.categories = categories;
		this.ingredients = ingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public Cook getCook() {
		return cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", recipeName=" + recipeName + ", recipeDescription=" + recipeDescription
				+ ", cook=" + cook + ", categories=" + categories + ", ingredients=" + ingredients + "]";
	}

}
