package com.skillstorm;

public class Encapsulation {

	public static void main(String[] args) {
		
		// ENCAPSULATION IN JAVA
		
		/*
		 * hide data/methods using access modifiers
		 * wrapping things up in a class
		 * constructors
		 */
		
		Car car = new Car();
//		System.out.println(car.getMake());
		
		Car car2 = new Car("Ford", "Festiva", 1989);
		System.out.println(car2.getInfo());
		
		System.out.println(car2);
		
		Rectangle r = new Rectangle(2, 8);
		
		System.out.println(r);
		
		r.setHeight(20);
		
		System.out.println(r);

	}

}

class Rectangle {
	
	private int width;
	private int height;
	private int area;
	
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.area = width * height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		this.area = this.width * this.height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		this.area = this.width * this.height;
	}

	public int getArea() {
		return area;
	}

	// don't want this, because we'd have to take in width and height anyway to make it make sense
//	public void setArea(int area) {
//		this.area = area;
//	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", area=" + area + "]";
	}
	
	
	
	
	
}



// NOW MOVED TO SEPARATE CAR CLASS!!

//class Car {
//	
//	// all of these properties/constructors/methods are non-static
//	// they belong to an individual instance
//	
//	// properties
//	String make;
//	String model;
//	int year;
//	
//	// constructors
//	// there is a default no-args constructor present if we don't create one
//	public Car(String make, String model, int year) {
//		// this calls Object's constructor
//		// if we don't include it, it's implied
//		// it MUST be first, if we include it
//		super();
//		this.make = make;
//		this.model = model;
//		this.year = year;
//	}
//	
//	// this is no longer the "default" constructor but a manually-created no-args constructor
//	// once we have another constructor, the default one is no longer available
//	// so we have to create our own
//	public Car() {}
//	
//	public String getInfo() {
//		return "I am a " + year + " " + make + " " + model + ".";
//	}
//
//	// this is an auto-generated toString
//	// it includes the @Override annotation because it overrides Object's toString
//	// this one includes all the properties as well as the Object type
//	@Override
//	public String toString() {
//		return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
//	}
//	
//	
//	
//	
//}







