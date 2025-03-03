package com.skillstorm;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTests {
	
	public static Calculator calc;
	
	// TESTING WITH JUNIT
	
	/*
	 * we have several annotation for methods in a test case class like this one
	 * 
	 * @BeforeClass -- static method that executes ONCE at the beginning of the test case (setup)
	 * - because it's static, we have to use static resources
	 * 
	 * @Before -- non-static method that executes immediately BEFORE EACH test
	 * 
	 * @Test -- an individual unit test
	 * 
	 * @After -- non-static methods that executes immediately AFTER EACH test
	 * 
	 * @AfterClass -- static method that executes ONCE at the end of the test case (teardown)
	 */

	
	// this is a generic stub test
	// general format of a test = do something with your actual code, then assert something about the result
	// if the assertion is correct, it'll pass
	// if the assertion is incorrect, it'll fail and throw an AssertionError
	// regardless of pass/fail, ALL tests will execute
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@BeforeClass
	public static void createCalculator() {
		System.out.println("BeforeClass...");
		calc = new Calculator("Testing Calculator");
	}
	
	@Before
	public void before() {
		System.out.println("Before...");
	}
	
	@Test
	public void calcConstruction() {
		System.out.println("calcConstruction...");
		Calculator temp = new Calculator("Temp");
		// not necessarily recommended to make multiple assertions in the same test
		// but it is possible
		assertEquals(Calculator.class, temp.getClass());
		assertEquals("Temp", temp.name);
	}
	
	@Test
	public void basicAddition() {
		System.out.println("basicAddition...");
		int result = 0;
		
		try {
			result = calc.add(1, 1);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		
		assertEquals(2, result);
	}
	
	// this tested action should throw an IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void divideByZero() {
		System.out.println("divideByZero...");
		double result = calc.divide(9, 0);
	}
	
	@Test(expected = OutOfBoundsException.class)
	public void integerOverflow() throws OutOfBoundsException {
		System.out.println("integerOverflow...");
		int result = calc.add(2000000000, 1000000000);
	}
	
	@Test(expected = OutOfBoundsException.class)
	public void integerUnderflow() throws OutOfBoundsException {
		System.out.println("integerUnderflow...");
		int result = calc.add(-2000000000, -1000000000);
	}
	
	// to test for the correct exception when overflowing in the multiply method
	@Test(expected = OutOfBoundsException.class)
	public void multiplicationOverflow() throws OutOfBoundsException {
		System.out.println("multiplicationOverflow...");
		int result = calc.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}
	
	@Test
	public void basicMultiplication() {
		System.out.println("basicMultiplication...");
		int result = 0;
		try {
			result = calc.multiply(5, 7);
		} catch (OutOfBoundsException e) {
			e.printStackTrace();
		}
		assertEquals(35, result);
	} 
	
	// testing for proper division accuracy
	@Test
	public void divisionAccuracy() {
		System.out.println("divisionAccuracy...");
		double result = calc.divide(1, 3);
		// when dealing with potentially imprecise results
		// we can use the third parameter of assertEquals to set a "delta" or margin of error
		assertEquals(0.3333, result, 0.0001);
	}
	
	@After
	public void after() {
		System.out.println("After...");
	}
	
	@AfterClass
	public static void deleteCalculator() {
		System.out.println("AfterClass...");
		calc = null;
	}

}

















