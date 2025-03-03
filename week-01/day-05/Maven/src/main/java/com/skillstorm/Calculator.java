package com.skillstorm;

// this class will be tested by our JUnit Test Case
public class Calculator {
	
	String name;
	
	public Calculator(String name) {
		this.name = name;
	}
	
	public int add(int x, int y) throws OutOfBoundsException {
		long result = (long)x + (long)y;
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			throw new OutOfBoundsException();
		
		return x + y;
	}
	
	public int subtract(int x, int y) throws OutOfBoundsException {
		
		long result = (long)x - (long)y;
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			throw new OutOfBoundsException();
		
		return x - y; 
	}
	
	public int multiply(int x, int y) throws OutOfBoundsException {
		
		long result = (long)x * (long)y;
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			throw new OutOfBoundsException();
		
		return x * y;
	}
	 
	// IllegalArgumentException is a RuntimeException, so you don't have to declare that this method throws it
	// changed the return type to double to allow for decimal responses
	// could refactor to take in doubles to avoid the casting...but careful of other edge cases!
	public double divide(int x, int y) {
		if (y == 0)
			throw new IllegalArgumentException();
		
		// we must cast to double BEFORE dividing, otherwise it'll send an int to the return anyway
		return (double)x / (double)y;
	}

}

class OutOfBoundsException extends Exception {}
