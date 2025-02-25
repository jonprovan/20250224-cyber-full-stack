package com.skillstorm;

public class Inheritance {

	public static void main(String[] args) {
		
		// INHERITANCE IN JAVA
		
		/*
		 * you can only inherit from ONE class directly
		 * hierarchically, you can stack as deeply as you need
		 * child classes/subclasses take in ALL properties and methods from the parent
		 * you can refer to them using this, just like regular properties
		 * 
		 */
		
		B b = new B(3, 5);
		System.out.println(b.number);
		
		b.sayA();
		
		C c = new C(23, 56, 89);
		
		// don't need to override getters/setters or other methods in a child class UNLESS YOU WANT TO!
		c.setNumber(111);

	}

}

class A {
	
	int number;
	
	public A(int number) {
		if (number > 100)
			this.number = 0;
		else
			this.number = number;
	}
	
	public A() {}
	
	public void sayA() {
		System.out.println("I am an A.");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}

class AA {}

class B extends A {
	
	int otherNumber;
	
	// constructor chaining
	// we can reuse logic from inherited classes' constructors to not duplicate validation/logic, etc.
	public B(int number, int otherNumber) {
		super(number);
		this.otherNumber = otherNumber;
	}
	
}

class C extends B {
	
	int thirdNumber;
	
	// chaining again here
	public C(int number, int otherNumber, int thirdNumber) {
		super(number, otherNumber);
		this.thirdNumber = thirdNumber;
	}
	
	
}







