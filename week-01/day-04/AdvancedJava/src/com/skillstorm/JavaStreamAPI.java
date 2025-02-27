package com.skillstorm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		 * - forEach -- terminal, does something for each item, returns nothing to the Stream
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
		
		// creating Streams
		
		// creating a one-off Stream
		Stream<Integer> myOneOffStream = Stream.of(1, 2, 3, 4, 5);
		
		// if we have a Collection ready, we can create as many Streams as we like from it
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
//		LinkedList<Integer> list = new LinkedList<>();
		
		// this returns a new Stream from the Collection
		list.stream();
		
		// forEach()
		// terminal
		// does not return a new Stream
		// requires a Consumer function as a parameter that takes in something and returns nothing
		// we DO NOT need to type the parameter in this case, because it's automatically whatever's in our Stream
		
		System.out.println("forEach()");
		
		list.stream().forEach(element -> {
			System.out.println(element * 2);
		});
		
		
		// map()
		// non-terminal
		// it returns a new Stream with the modified elements
		// requires a Producer function as a parameter that takes in something and returns something
		// we don't need to type the parameter here either
		
		System.out.println("\nmap()");
		
		// without a terminal operation chained after this, the map() function does not execute
		// NOTE -- elements are processed ALL THE WAY THROUGH before the other elements are processed
		// .map() does not complete all its actions before forEach() in this case 
		list.stream().map(element -> {
			System.out.println("Original element: " + element);
			return element * 2;
		}).forEach(element -> {
			System.out.println("Final element: " + element);
		});
		
		
		// filter()
		// non-terminal
		// it returns a new Stream with the remaining elements
		// requires a Predicate function as a parameter that takes in something and returns a boolean (true if criteria are met)
		// the incoming element is NOT changed in a filter() operation
		// still don't need to type the parameter
		
		System.out.println("\nfilter()");
		
		list.stream().filter(element -> {
			System.out.println("Incoming set: " + element);
//			if (element % 2 == 0)
//				return true;
//			else
//				return false;
			// same thing
			return element % 2 == 0;
		}).forEach(element -> System.out.println("Included in result: " + element));
		
		
		// reduce()
		// terminal
		// it DOES NOT return a Stream, it ONLY returns one value
		// requires an Accumulator function that takes in two things and returns one to be processed again until we're done
		// we DO need to type the parameters this time (sometimes...?)
		Integer result = list.stream().reduce(100, (num1, num2) -> {
			return num1 + num2;
		});
		
		System.out.println(result);
		
		Optional<Integer> result2 = list.stream().reduce((num1, num2) -> {
			return num1 + num2;
		});
		
		if (result2.isPresent())
			System.out.println(result2.get());
		
		LinkedList<String> strList = new LinkedList<>(Arrays.asList("ghi", "abc", "jkl", "def"));
		
		// using reduce on Strings to return the earliest in alpha order
		Optional<String> strResult = strList.stream().reduce((str1, str2) -> {
			if (str1.compareTo(str2) > 0)
				return str2;
			else
				return str1;
		});
		
		if (strResult.isPresent())
			System.out.println(strResult.get());

	}

}
