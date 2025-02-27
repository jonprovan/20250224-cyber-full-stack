package com.skillstorm;

public class JavaStreamAPI {

	public static void main(String[] args) {
		
		// THE JAVA STREAM API
		
		/*
		 * In general, we can create a Stream from a collection
		 * Then take one or more actions on the items in that Stream
		 * This DOES NOT alter the items in the Stream unless we want it to
		 * 
		 * We can easily chain together a series of actions in a readable way
		 * This also eliminates in-between variables, which saves some memory
		 * It also reduces the likelihood of errors with miscalling variables, etc.
		 * 
		 * Streams are one-use-only!
		 * Once you process a Stream, you can't go back to it and must create a new one
		 * We can take non-terminal and terminal actions on a Stream
		 * Once we take a terminal action, the Stream is closed
		 * If we DON'T take a terminal action on a Stream...
		 * ...NONE of the Stream actions EVER take place!
		 * 
		 * Also, the order of processing within Streams is not what you'd expect!
		 * 
		 * Many Stream methods are available; we'll focus on four:
		 * - forEach -- terminal, does something for each item, returns nothing
		 * - map -- non-termimal, does something with each item, puts it back in the Stream
		 * - filter -- non-terminal, returns items to the Stream that match some criteria
		 * - reduce -- terminal, returns a single value of some sort
		 * 
		 * LAMBDAS = short-form versions of methods/functions
		 * A few rules:
		 * 
		 * For parameters:
		 * if none, must use parentheses
		 * if one, parentheses optional
		 * if more than one, must use parentheses
		 * 
		 * () -> code
		 * int num -> code OR (int num) -> code
		 * (int num1, int num2) -> code
		 * 
		 * For the code:
		 * if one line only, no need for braces
		 * if more than one line, braces required
		 * if the function returns something and is one line only WITH NO BRACES, return keyword NOT required
		 * if braces are used, regardless of the number of lines, return keyword REQUIRED (if not void)
		 * 
		 * () -> System.out.println("abc")
		 * () -> { System.out.println("abc"); System.out.println("xyz"); }
		 * () -> "abc"
		 * () -> { return "abc"; }
		 * 
		 */

	}

}
