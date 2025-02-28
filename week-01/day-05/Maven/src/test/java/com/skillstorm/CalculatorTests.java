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
		int result = calc.divide(9, 0);
	}
	
	@Test(expected = OutOfBoundsException.class)
	public void integerOverflow() throws OutOfBoundsException {
		System.out.println("integerOverflow...");
		int result = calc.add(2000000000, 1000000000);
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
