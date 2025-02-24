package com.skillstorm;

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
		
		

	}

}
