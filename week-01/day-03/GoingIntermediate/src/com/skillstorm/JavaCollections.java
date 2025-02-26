package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class JavaCollections {

	public static void main(String[] args) {

		// COLLECTIONS IN JAVA
		
		/*
		 * List
		 * - LinkedList, ArrayList
		 * - non-fixed size (true for all!)
		 * - duplicates allowed
		 * - unsorted
		 * - ordered
		 * - iterable
		 * - indexed
		 * 
		 * Set
		 * - HashSet, TreeSet
		 * - duplicates forbidden!
		 * - ordering/sorting depends (HashSet no, TreeSet yes)
		 * 
		 * Map
		 * - HashMap, TreeMap
		 * - key-value pairs
		 * - duplicate values allowed, duplicate keys not
		 * - duplicate hashes ARE allowed
		 * - sorting depends (HashMap no, TreeMap has sorted keys)
		 * - not directly iterable
		 * 
		 * Stacks & Queues
		 * - Stack, Queue interface, Deque interface, PriorityQueue
		 * - ordered (PQ as an exception)
		 * - PQ is sorted on exit
		 * - Stack = FILO/LIFO
		 * - Queue = FIFO
		 */
		
		// Lists
		// List is an interface, so we can't instantiate it directly
//		List<String> myList = new List<>();
		
		// ArrayList
		// arrays under the hood
		// resizable, via removal of the original underlying array and replacement with a new one
		// time-expensive to replace the array
		// time-expensive to insert/remove in the middle
		// very fast access -- indexed like an array, can get there immediately
		// NO PRIMITIVES ALLOWED! Objects only
		// for "primitives," we need to use wrapper classes like Integer, Character, Boolean, etc.
		List<String> myAL = new ArrayList<>();
		
		myAL.add("One"); // adding at the end
		myAL.add("Two");
		myAL.addFirst("Three"); // adding at the beginning
		myAL.add(2, "Four"); // adding at an index
		
		System.out.println(myAL);
		
		myAL.remove(2); // removing at an index
		
		System.out.println(myAL);
		
		myAL.add("One");
		myAL.remove("One"); // removing the first instance of this element
		
		System.out.println(myAL);
		
		System.out.println(myAL.get(1)); // getting the value of an element
		myAL.set(1, "Five"); // setting/replacing the value of an element
		
		System.out.println(myAL);
		
		// LinkedList
		// all the above methods work for LinkedLists as well (both implement the List interface)
		// elements can be ANYWHERE in memory
		// each element (or node) has a pointer to the next node and one to the previous node
		// the LinkedList object only contains pointers to the first and last elements
		// time-expensive to access elements, because we have to walk through the chain
		// quick to insert/remove, because we just have to change the pointers
		List<Integer> myLL = new LinkedList<>();
		
		
		// Set
		// Set is also an interface
//		Set<String> mySet = new Set<>();
		
		// elements in HashSet are not sorted or ordered
		Set<String> myHashSet = new HashSet<>();
		
		myHashSet.add("Sauron");
		myHashSet.add("Frodo");
		myHashSet.add("Tom Bombadil");
		myHashSet.add("Samwise");
		myHashSet.add("Balrog");
		myHashSet.add("Legolas");
		
		// adding a duplicate element does not add anything or throw an Exception
		// it DOES return false, so you can tell if it was already in there
		System.out.println(myHashSet.add("Balrog"));
		
		System.out.println(myHashSet);
		
		System.out.println(myHashSet.contains("Frodo"));
		System.out.println(myHashSet.containsAll(new LinkedList<String>(Arrays.asList("Frodo", "Bilbo"))));
		
		myHashSet.remove("Sauron");
		System.out.println(myHashSet);
		
		// TreeSet is sorted
		// you can feed in your own sorting method if you like
		Set<String> myTreeSet = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
		myTreeSet.add("Sauron");
		myTreeSet.add("Frodo");
		myTreeSet.add("Tom Bombadil");
		myTreeSet.add("Samwise");
		myTreeSet.add("Balrog");
		myTreeSet.add("Legolas");
		
		System.out.println(myTreeSet);
		
		
		// Stacks and Queues
		// you CAN instantiate a stack, but the Deque interface is better and should be used
		Stack<Integer> myStack = new Stack<>();
		
		// Queue is an interface, so we'll use LinkedList under the hood
		// FIFO -- first in, first out
		Queue<String> q = new LinkedList<>();
		
		// we can use .add and .remove, but they throw certain exceptions if the queue is full or empty, respectively
		// so we use .offer to add at the end and .poll to grab from the beginning
		q.offer("Customer One");
		q.offer("Customer Two");
		q.offer("Customer Three");
		
		System.out.println(q);
		
		// poll removes AND returns the first element
		String s = q.poll();
		
		System.out.println(q);
		
		// peek lets us look at the element without removing it from the queue
		System.out.println(q.peek());
		
		System.out.println(q);
		
		// for a stack or a queue that needs to go in both directions, use the Deque interface
		// you have offer and poll options at both ends
		// you also have push and pop for stack functionality
		
		Deque<String> d = new LinkedList<>();
		
		// using it like a stack
		// push adds something to the "top", pop removes it 
		d.push("Plate One");
		d.push("Plate Two");
		d.push("Plate Three");
		
		System.out.println(d);
		
		System.out.println(d.pop());
		
		System.out.println(d);
		
		// using it like a deque
		d.offerFirst("Plate Four");
		d.offerFirst("Plate Five");
		
		System.out.println(d.pollLast());
		
		System.out.println(d);
		
		d.offerLast("Plate Six");
		d.offerLast("Plate Seven");
		
		System.out.println(d.pollFirst());
		
		System.out.println(d);
		
		
		// Map
		// fast access, they are arrays under the hood
		// our keys are essentially indices in the array
		// we don't need to know the indices, we can just get the value associated with a key
		// Maps are structured just like JSON objects
		
		// HashMap
		// keys are hashes of the key objects
		// any object can be hashed using the .hashCode() method from Object
		System.out.println(new Object().hashCode());
		System.out.println(new Object().hashCode());
		
		// we need two types in the declaration <Key, Value>, and they must both be objects, not primitives
		Map<String, Integer> ages = new HashMap<>();
		
		// use .put to add a key/value pair to your Map
		ages.put("Yoda", 990);
		ages.put("Darth Vader", 45);
		ages.put("Princess Leia", 65);
		
		// to retrieve a value
		System.out.println(ages.get("Darth Vader"));
		
		// to overwrite a value
		ages.put("Darth Vader", 46);
		
		System.out.println(ages.get("Darth Vader"));
		
		System.out.println();
		
		// working with our own class
		Map<Movie, String> movieCharacters = new HashMap<>();
		
		movieCharacters.put(new Movie("Star Trek", "PG"), "James Tiberius Kirk");
		movieCharacters.put(new Movie("Dune", "PG-13"), "Paul Atreides");
		movieCharacters.put(new Movie("Jurassic Park", "PG-13"), "Alan Grant");
		// this doesn't work as expected, because the two objects have different hashcodes
//		movieCharacters.put(new Movie("Jurassic Park", "PG-13"), "The T-Rex");
		
		// to loop through a map, which is not iterable, use the keySet method to get the keys, then loop through those
		for (Movie key : movieCharacters.keySet()) {
			System.out.println(key + ": " + movieCharacters.get(key));
		}
		
		// this doesn't work as expected for the same reason
		String lead = movieCharacters.get(new Movie("Jurassic Park", "PG-13"));
		System.out.println(lead);
		
		// the hashCode/equals contract
		// objects whose state has not changed must consistently return the same hashCode
		// two objects that are equal (our standards) MUST return the same hashCode
		// two objects that are NOT equal CAN return the same hashCode, like this:
		System.out.println("Aa".hashCode());
		System.out.println("BB".hashCode());
		
		// to make our Map work properly, we need to override both the hashCode and equals methods (SEE CLASS BELOW!)
		
		// now simple equality comparison works as well!
		System.out.println(new Movie("Test", "R").equals(new Movie("Test", "R")));
		
		
	}
	
}

// we'll use this as our key to get lead-character-name values
class Movie {
	
	String title;
	String rating;
	
	public Movie(String title, String rating) {
		this.title = title;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + "]";
	}

	// this will return an identical hash for ANY Movie object with the same title and rating
	@Override // of Object's hashCode method
	public int hashCode() {
		return Objects.hash(rating, title);
	}

	// this will return true if the two Movies are equal by our standards (title and rating the same)
	@Override // of Object's equals method
	public boolean equals(Object obj) { 
		if (this == obj) // is the other object this object?
			return true;
		if (obj == null) // is the other object null?
			return false;
		if (getClass() != obj.getClass()) // is the other object a Movie?
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(rating, other.rating) && Objects.equals(title, other.title); // returns true if both string values are equal
	}
	
	
	
}
