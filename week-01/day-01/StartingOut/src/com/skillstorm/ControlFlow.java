package com.skillstorm;

import java.util.LinkedList;
import java.util.List;

public class ControlFlow {

	public static void main(String[] args) {
		
		// CONTROL FLOW IN JAVA
		
		/*
		 * BRANCHING
		 * if
		 * else
		 * else if
		 * switch
		 * 
		 * LOOPS
		 * while
		 * do-while
		 * standard for
		 * enhanced for
		 * labels
		 * 
		 * COMMON
		 * break
		 * continue
		 * 
		 * EXCEPTION HANDLING (at a later date!)
		 * 
		 */
		
		// if
		// if a condition is true, do the next line or block
		if (3 < 6) {
			System.out.println("If statement was true");
		}
		
		// if you only have one conditional line, you don't need the braces
		if (4 % 2 == 0)
			System.out.println("Other if was true");
		
		// else
		// requires an if or else if beforehand
		// this a catchall for any remaining possibilities
		if ("red" == "green")
			System.out.println("Hell has frozen over.");
		else
			System.out.println("All is right in the world.");
		
		// else if
		if (1 * 9 == 10)
			System.out.println("It's 10!");
		else if (1 * 9 == 8)
			System.out.println("It's 8!");
		else if (1 * 9 == 9)
			System.out.println("It's 9!");
		else
			System.out.println("Nothing is right at all.");
		
		
		// switch
		// we use switch to "choose" between several possibilities
		// you CANNOT switch on a boolean! must be something with three or more possible values
		// each possibility is a case
		// you can optionally add a default to catch any other possibility -- DOES NOT have to be at the end
		// if you don't insert break statements, the code will cascade through all remaining possibilities
		String name = "Marco Polo";
		
		switch (name) {
			case "Joan of Arc":
				System.out.println("It was Joan.");
				break;
			case "Marco Polo":
				System.out.println("It was Marco.");
				break;
			case "Grimace":
				System.out.println("It was Grimace.");
				break;
			default:
				System.out.println("It was no one we know!");
				break;
		}
		
		// LOOPS
		
		// while
		// executes as long as a condition is true
		// the condition is evaluated FIRST, before the code ever executes
		int counter = 0;
		
		while (counter < 3) {
			System.out.println("WHILE counter value = "+ counter);
			counter++;
		}
		
		// do-while
		// just like a while loop, but we check the condition first
		counter = 0;
		
		do {
			System.out.println("DO-WHILE counter value = "+ counter);
			counter++;
		} while (counter < 3);
		
		// standard for
		// iterate through collections while retaining access to the index
		// also good for doing things a fixed number of times
		// requires more setup than the enhanced for
		
		
		// Copyright 2025 Nikash -- noice!
		// in the parentheses -- a starting action, a condition to check BEFORE each iteration, an action to take AFTER each iteration
		// ALL are optional, depending on the structure of your loop
		for (char c = 'a'; c <= 'e'; c++) {
			System.out.println(c);
		}
		
		char c = 'a';
		
		for (int i = 0; i <= 4; i++) {
			System.out.println(c++);
		}
		
		int[] nums = { 2, 4, 6, 8, 10 };
		
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		// without the break, this would be an infinite loop
		for (;;) {
			System.out.println("Uh-oh...");
			break;
		}
		
		// enhanced for (some people call this a foreach)
		// this is great for simply iterating through Collections/arrays that are iterable (LinkedList, Set)
		// some Collections are not iterable, like HashMap
		// disadvantage is we don't have direct access to the loop index
		for (int num : nums) {
			num = num + 4;
			System.out.println(num);
		}
		
		// the local variable num in the above loop is pass-by-value and has no effect on the original array
		// just like our pass-by-reference examples
		for (int num : nums) {
			System.out.println(num);
		}
		
		List<String> names = new LinkedList<>();
		names.add("Muhiddin");
		names.add("Dhruv");
		names.add("Leah");
		
		for (String singleName : names) {
			System.out.println(singleName);
		}
		
		// BREAK AND CONTINUE
		// break will end the loop entirely, moving on to the next piece of code
		// continue will end THIS ITERATION but move on to the next iteration without breaking the overall loop
		
		System.out.println("\nBefore...");
		
		for (int i = 0; i < 5; i++) {
			if (i == 2)
				continue; // can only use in loops, not switches, etc.! #LiamResearchFTW
			if (i == 4)
				break;
			System.out.println("Loop Index = " + i);
		}
		
		System.out.println("...and after\n");
		
		// LOOP LABELS
		// we can label individual loops in a nested-loop situation to take action on a specific loop
		int[][] numsWithinNums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		
		// you can label loops to access them from other loops
		// we can then break/continue either loop by calling it
		OUTER: for (int i = 0; i < numsWithinNums.length; i++) {
			
			System.out.println("Outer Loop Index = " + i);
			
			// must use a different variable name here, because i is still in scope from the outer array
			INNER: for (int j = 0; j < numsWithinNums[i].length; j++) {
				
				if (i == 2)
					break OUTER;
				
				if (i == 1)
					continue OUTER;
				
				if (j == 1)
					break INNER;
				
				System.out.println("Inner Loop Index = " + j);
				
				System.out.println(numsWithinNums[i][j]);
			}
			
		}
		

	}

}
