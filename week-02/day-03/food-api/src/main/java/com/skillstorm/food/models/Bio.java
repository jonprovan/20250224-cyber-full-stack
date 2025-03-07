package com.skillstorm.food.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Bio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String cookDescription;
	
	// there is no reference to Cook in the Bio records
	// however, we still may wish to see the associated Cook when retrieving a Bio
	// the mappedBy property refers to the property name of the Cook class that maps the one-to-one relationship
	// we need the cascade property on the side that dictates cascading operations
	// here, we need to allow for setting Cook's bio to NULL on delete or changing Cook's bio on an update to Bio
	@OneToOne(mappedBy = "bio", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("bio")
	private Cook cook;
	
	public Bio() {
		super();
	}

	public Bio(int id, String cookDescription, Cook cook) {
		super();
		this.id = id;
		this.cookDescription = cookDescription;
		this.cook = cook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCookDescription() {
		return cookDescription;
	}

	public void setCookDescription(String cookDescription) {
		this.cookDescription = cookDescription;
	}

	public Cook getCook() {
		return cook;
	}

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	@Override
	public String toString() {
		return "Bio [id=" + id + ", cookDescription=" + cookDescription + ", cook=" + cook + "]";
	}

}
