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
	
	public int subtract(int x, int y) {
		return x - y;
	}
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	// IllegalArgumentException is a RuntimeException, so you don't have to declare that this method throws it
	public int divide(int x, int y) {
		if (y == 0)
			throw new IllegalArgumentException();
		
		return x / y;
	}

}

class OutOfBoundsException extends Exception {}
