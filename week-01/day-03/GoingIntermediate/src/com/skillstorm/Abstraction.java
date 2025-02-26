package com.skillstorm;

public class Abstraction {

	public static void main(String[] args) {
		
		// ABSTRACTION IN JAVA
		
		/*
		 * hiding implementation details from the user or another program
		 * we don't need to know HOW it works, just what it does
		 * 
		 * create abstract elements that will be implemented by child classes
		 * abstract classes and interfaces
		 * 
		 * things like the Factory Pattern
		 */
		
		// using abstract classes
		// you cannot instantiate an abstract class
//		Tree tree = new Tree();
		
		// we CAN do this, even if we use the abstract parent reference type, because and Elm IS-A Tree
		Tree elm = new Elm("Ulmus americana", 50, 45.5);
		
		elm.declareSelf();
		System.out.println(elm.produceSap() + " sap units");
		
		Tree loblolly = new Loblolly("Pinus taeda", 25, 34.1);
		
		loblolly.declareSelf();
		System.out.println(loblolly.produceSap() + " sap units");
		
		// using interfaces
		// CANNOT do this, because you can't instantiate an interface directly
//		WoodProducer wp = new WoodProducer();
		
		// have to instantiate an object from an implementing class
		Cherry c = new Cherry("Prunus canescens Bois", 10, 15.7);
		System.out.println(c.getPercentVolume());
		System.out.println(c.goodLumber());
		
		// calling our default method
		// not a strong use case for these; most often, methods in interfaces are abstract
		c.whyAmIHere();

	}

}

abstract class Tree {
	
	// properties
	String species;
	int age;
	double height;
	
	public Tree(String species, int age, double height) {
		this.species = species;
		this.age = age;
		this.height = height;
	}
	
	public void declareSelf() {
		System.out.println(species + ", " + age + " years old, " + height + " feet tall");
	}
	
	// this is an abstract method
	// we CANNOT provide it implementation here
	// we MUST provide it implementation somewhere along the inheritance tree
	abstract double produceSap();
	
}

class Elm extends Tree {
	
	public Elm(String species, int age, double height) {
		super(species, age, height);
	}

	@Override
	double produceSap() {
		
		return 50.1;
	}
	
}

abstract class Pine extends Tree {
	
	public Pine(String species, int age, double height) {
		super(species, age, height);
	}
	
	// we CAN do this here, which means subsequent children DO NOT have to implement these methods
	@Override
	double produceSap() {
		
		return 75.9;
	}
	
}

class Loblolly extends Pine {
	
	public Loblolly(String species, int age, double height) {
		super(species, age, height);
	}
	
	// or we can do it here -- as long as the contract is satisfied before we reach the end of the inheritance chain
//	@Override
//	double produceSap() {
//		
//		return 50.1;
//	}
	
}

interface WoodProducer {
	
	// properties in interfaces are final and static by default
	// final variables in Java are typically styled this way to indicate their status
	// essentially a class constant
	boolean PRODUCES_WOOD = true;
	
	// generally, methods in an interface are abstract and must be implemented by classes implementing the interface
	// you DO NOT need the abstract keyword in interfaces
	// methods in interfaces are public by default
	// you cannot reduce the visibility in implementing classes
	double getPercentVolume();
	boolean goodLumber();
	
	// this method is also contracted in FoodProducer
	void doubleMethod();
	
}

interface FoodProducer {
	double foodWeight();
	
	// this method is also contracted in WoodProducer
	void doubleMethod();
	
	// you CAN create methods with implementation in an interface
	// they DO NOT need to be overridden
	// use the default keyword
	default void whyAmIHere() {
		System.out.println("Explanation TBD...");
	}
}

// you CAN extend ONE class and implement as many interfaces as you like
// extends must come before implements in the class declaration
class Cherry extends Tree implements WoodProducer, FoodProducer {

	public Cherry(String species, int age, double height) {
		super(species, age, height);
	}

	@Override
	public double getPercentVolume() {
		
		return 25.1;
	}

	@Override
	public boolean goodLumber() {
		
		return true;
	}

	@Override
	double produceSap() {
		
		return 11.7;
	}

	@Override
	public double foodWeight() {
		
		return 1000;
	}
	
	// this single override satisfies BOTH contracts
	// we can't implement the same contract twice in a single class
	// BE CAREFUL!! this can cause unexpected behavior
	@Override
	public void doubleMethod() {
		System.out.println("Did it work?");
	}
	
}








