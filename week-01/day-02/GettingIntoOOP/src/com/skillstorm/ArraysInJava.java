package com.skillstorm;

import java.util.Arrays;

public class ArraysInJava {

	public static void main(String[] args) {
		
		// ARRAYS IN JAVA
		
		/*
		 * contiguous section of memory, stored in the Heap
		 * memory address is the start, then we access values within it relative to the start via index (0 start)
		 * can hold primitives as well as Objects
		 * but they're typed, so we can only include elements of the same type (or children)
		 * fixed size/length -- must create a new one to add/remove slots
		 * iterable
		 */
		
		// declare an array without giving it a size
		int[] nums; // can fill this with an int[] of any size
		int nums2[]; // can also do this, but...I don't like it
		
		// after this, the new array instantiated is fixed at this size
		nums = new int[5];
		// but, we can point the variable to any valid int[]
		nums = new int[6];
		
		// arrays are filled with default values
		// 0 or its equivalent for all numerical types, null for all Object types
		System.out.println(nums[4]);
		
		// you will throw an Exception if you try to access an index that's out of bounds
//		System.out.println(nums[11]);
		
		nums[1] = 5;
		nums[3] = 77;
		nums[5] = 42;
		
		
		// arrays do not have a toString override
		System.out.println(nums);
		
		for (int num : nums)
			System.out.println(num);
		
		// you CAN use a utility class to get a toString method that prints how you would expect
		System.out.println(Arrays.toString(nums));
		
		// you can give an array values at instantiation using an array literal
		int[] nums3 = { 4, 1, -234, 9999 };
		
		for (int num : nums3)
			System.out.println(num);
		
		System.out.println(nums3[2]);
		
		// you can use the Arrays class to sort as well
		Arrays.sort(nums3);
		
		System.out.println(Arrays.toString(nums3));
		
		// can do this, because they all are descendants of Grandparent
		// if I have common methods/properties, I can access them easily
		// however, if something is NOT present at the Grandparent level, I have to jump through some hoops
		Grandparent[] gps = { new Grandparent(), new Parent(), new Child() };
		
		// the speak method works for all classes, because it's overridden from the top down
		// but scream only exists in the Parent class, so we have to 1. check if the Object is a Parent, 2. cast it as a Parent to get access
		for (Grandparent g : gps) {
			g.speak();
			if (g.getClass().equals(Parent.class))
				((Parent)g).scream();
		}

	}

}

class Grandparent {
	void speak() {
		System.out.println("Grandparent");
	};
}

class Parent extends Grandparent {
	@Override // common to include this for readability, but doesn't change functionality and works without it
	void speak() {
		System.out.println("Parent");
	};
	
	void scream() {
		System.out.println("Ack! I'm a Parent!");
	}
}

class Child extends Parent {
	@Override
	void speak() {
		System.out.println("Child");
	};
}







