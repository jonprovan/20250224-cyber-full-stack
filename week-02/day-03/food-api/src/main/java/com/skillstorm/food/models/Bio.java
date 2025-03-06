package com.skillstorm.food.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Bio() {
		super();
	}

	public Bio(int id, String cookDescription) {
		super();
		this.id = id;
		this.cookDescription = cookDescription;
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

	@Override
	public String toString() {
		return "Bio [id=" + id + ", cookDescription=" + cookDescription + "]";
	}

}
