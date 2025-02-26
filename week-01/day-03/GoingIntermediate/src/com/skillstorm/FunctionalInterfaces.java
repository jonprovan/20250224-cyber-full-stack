package com.skillstorm;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		// FUNCTIONAL INTERFACES IN JAVA
		
		/*
		 * a functional interface is an interface that has EXACTLY ONE abstract method
		 * 
		 * we can fill the abstract method with implementation at runtime
		 * we DO NOT need to create an actual class that implements the method
		 */
		
		// one way to implement these is using lambda syntax
		FuncInt f1 = () -> {
			System.out.println("F1 Implemented!");
		};
		
		FuncInt f2 = () -> {
			System.out.println("F2 Implemented!");
		};
		
		FuncInt f3 = new FuncInt() {
			
			@Override
			public void implementMe() {
				System.out.println("F3 Implemented!");	
			}
		};
		
		f1.implementMe();
		f2.implementMe();
		f3.implementMe();
		
		// an example with sorting
		Integer[] nums = { 3, -50, 66, 12345, -999 };
		
		System.out.println(Arrays.toString(nums));
		
		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		Arrays.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		// this does the same thing in shorthand, like our initial instantiated FuncInt
//		Arrays.sort(nums, (Integer o1, Integer o2) -> o2 - o1);
		
		System.out.println(Arrays.toString(nums));
		
	}

}

// this annotation will not allow more than one abstract method in the interface
// it is not required, but it can help protect you from setting things up wrong
@FunctionalInterface
interface FuncInt {
	// we can have one and only one abstract method
	void implementMe();
//	void implementMeToo();
}
