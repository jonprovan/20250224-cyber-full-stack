package com.skillstorm;

import java.util.LinkedList;

public class VariablesAndDataTypes {

	public static void main(String[] args) {
		
		// VARIABLES AND DATA TYPES IN JAVA
		
		/*
		 * Two main categories -- primitives and Objects
		 * 
		 * PRIMITIVES
		 * - stored on the stack
		 * 
		 * Whole Numbers
		 * byte - 8 bits
		 * short - 16 bits
		 * int - 32 bits
		 * long - 64 bits
		 * 
		 * Decimal Numbers
		 * float - 32 bits
		 * double - 64 bits
		 * 
		 * True/False
		 * boolean
		 * 
		 * Alphanumeric
		 * char
		 * 
		 * OBJECTS
		 * - stored on the heap
		 * 
		 * Many Java classes we'll use
		 * User-generated objects from custom classes
		 * Any imports from other packages/libraries
		 * Collections and arrays
		 * Errors and Exceptions
		 * 
		 */
		
		// to declare a variable
		// we need a reference type and a name
		int x;
		
		// we can then initialize it with a value
		x = 10;
		
		int y = 100;
		
		// a final variable, once initialized, cannot be changed
		final int z = 1000;
		// z = 2000; cannot do this, because it's final
		
		final int f;
		f = 123;
		
		LinkedList<String> list = new LinkedList<>();
		// to remove the object on the heap, I have to remove all references to it
		list = null;
		
		int[] nums = { 1, 2, 3 };
		
		// if I want/need Java to think about my whole number as something other than an int, I have to cast it like this
		short myShort = (short)123456;
		
		// this is also true for numbers outside the int range
		long myLong = 555555555555L;
		
		// because the method expects a byte, I have to cast the input to a byte
		System.out.println(addThree((byte)4));

	}
	
	static byte addThree(byte x) {
		// I also have to cast the return, because it adds up to an int
		return (byte)(x + 3);
	}

}
