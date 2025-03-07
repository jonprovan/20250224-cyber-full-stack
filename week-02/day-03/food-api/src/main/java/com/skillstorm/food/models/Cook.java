package com.skillstorm.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	// this is what we'd have if we didn't want to have Hibernate "relate" our classes/objects/records
//	@Column
//	private int bio;
	
	// but we want to relate our classes and see those related objects when we return this class to the user
	// this is a one-to-one relationship, so we use @OneToOne
	// @JoinColumn lays out HOW they're related -- name is the name of the column in this table with the foreign key
	// referencedColumnName is the name of the column in the other table to which the foreign key refers
	// we DO NOT have to specify the other table -- that is dictated by the type of the variable (Bio)
	@OneToOne
	@JoinColumn(name = "bio", referencedColumnName = "id")
	// we can ignore the entire Bio object like this when printing to JSON
//	@JsonIgnore
	// or, we can ignore certain parts of the object
	@JsonIgnoreProperties("cook")
	private Bio bio;
	
	public Cook() {
		super();
	}

	public Cook(int id, String firstName, String lastName, Bio bio) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Bio getBio() {
		return bio;
	}

	public void setBio(Bio bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Cook [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", bio=" + bio + "]";
	}
	
}
