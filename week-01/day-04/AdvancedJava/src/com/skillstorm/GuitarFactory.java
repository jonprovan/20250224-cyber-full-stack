package com.skillstorm;

public class GuitarFactory {
	
	// THE FACTORY PATTERN IN JAVA
	
	/*
	 * the idea is to conceal the construction of objects from the user
	 * the user might know the general thing they'll receive
	 * BUT, they don't know what specific thing they'll receive or how/why it's made
	 * 
	 * we'll use packages to limit functionality for what a user can do
	 */
	
	// many Factory Patterns use static methods to return their goods
	// this way, the end user doesn't even have to instantiate a factory object to get what they want
	// LoggerFactory in Spring Boot is a great example -- LoggerFactory.getLogger()
	public static Guitar getGuitarByPrice(double budget) throws Exception {
		
		if (budget >= 5999999.99)
			return new D18E();
		
		if (budget >= 1499.99)
			return new Stratocaster();
		
		if (budget >= 299.99)
			return new Talman();
		
		throw new Exception("Our least expensive Guitar is $299.99.");
		
	}
	
	public static Guitar getGuitarByModel(String model) throws Exception {
		
		switch (model) {
			case "Talman": return new Talman();
			case "Stratocaster": return new Stratocaster();
			case "D18E": return new D18E();
			default: throw new Exception("We have no models with that name.");
		}
		
	}

}
