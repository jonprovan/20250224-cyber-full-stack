package com.skillstorm;

public class Car {
	
	// all of these properties/constructors/methods are non-static
	// they belong to an individual instance
	
	// properties
	private String make;
	private String model;
	private int year;
	private boolean rad = true;
	
	// constructors
	// there is a default no-args constructor present if we don't create one
	public Car(String make, String model, int year) {
		// this calls Object's constructor
		// if we don't include it, it's implied
		// it MUST be first, if we include it
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	// this is no longer the "default" constructor but a manually-created no-args constructor
	// once we have another constructor, the default one is no longer available
	// so we have to create our own
	public Car() {}
	
	public String getInfo() {
		return "I am a " + year + " " + make + " " + model + ".";
	}

	// this is an auto-generated toString
	// it includes the @Override annotation because it overrides Object's toString
	// this one includes all the properties as well as the Object type
	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
	}
	
	// getters and setters
	// make sure you follow the naming convention for these, because Spring Boot/Hibernate will expect it
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) throws IllegalArgumentException {
		if (year < 1915 || year > 2025)
			throw new IllegalArgumentException("Year must be between 1915 and 2025!");
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// note that the getter for boolean properties has a different naming convention
	public boolean isRad() {
		return rad;
	}

	public void setRad(boolean rad) {
		this.rad = rad;
	}
	
	
	
	
	
	
	
}
