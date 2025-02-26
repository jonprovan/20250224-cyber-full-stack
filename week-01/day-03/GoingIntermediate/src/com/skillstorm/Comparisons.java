package com.skillstorm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Comparisons {

	public static void main(String[] args) {
		
		// COMPARISONS IN JAVA
		
		/*
		 * for our custom objects, we have similar problems when comparing that we do with equals
		 * things like Strings and numbers have a natural sorting order
		 * custom objects do not
		 * 
		 * Comparable and Comparator
		 * 
		 * Comparable is an interface you implement in a class to compare it to other objects of the same type
		 * 
		 * Comparator is an interface you implement in a third-party class that you can use to compare two objects of the same type
		 */
		
		// natural sort order for numbers
		int[] nums = { 5, 1, -10, 907, -100000 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		List<Superhero> heroes = new LinkedList<>();
		
		heroes.add(new Superhero("Batman", 10, "The Joker"));
		heroes.add(new Superhero("Superman", 9999999, "Lex Luthor"));
		heroes.add(new Superhero("Homelander", 88, "Billy Butcher"));
		heroes.add(new Superhero("Flash", 30, "Reverse Flash"));
		heroes.add(new Superhero("Spiderman", 25, "J. Jonah Jameson"));
		
		for (Superhero hero : heroes)
			System.out.println(hero);

		System.out.println();
		
		// cannot do this without implementing Comparable, because there is no natural sort order!
		// once implemented, we now sort by powerLevel descending
		Collections.sort(heroes);
		
		for (Superhero hero : heroes)
			System.out.println(hero);
		
		System.out.println();
		
		// what if I ALSO want to sort by name?
		NameSorter ns = new NameSorter();
		
		// when using a Comparator, feed it into the sort() method as the second parameter
		// whether the class to be sorted is Comparable or not, it will use the Comparator (instead)
		Collections.sort(heroes, ns);
		
		for (Superhero hero : heroes)
			System.out.println(hero);
		
		System.out.println();
		
		// you can also provide Comparator functionality inline without creating a separate class
		Collections.sort(heroes, (Superhero o1, Superhero o2) -> o1.archenemy.compareTo(o2.archenemy));
		
		for (Superhero hero : heroes)
			System.out.println(hero);
		
		System.out.println();
		
		// A NOTE ABOUT PRIORITY QUEUES
		// elements are sorted as they are removed
		// internal order is unpredictable
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(4);
		pq.offer(11);
		pq.offer(-89);
		pq.offer(-654);
		pq.offer(566);
		pq.offer(12);
		pq.offer(0);
		
		System.out.println(pq);
		
		// they exit according to natural sort order
		while (!pq.isEmpty())
			System.out.println(pq.poll());
		
		System.out.println();
		
		// or we can provide a Comparator to use
		pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
		
		pq.offer(4);
		pq.offer(11);
		pq.offer(-89);
		pq.offer(-654);
		pq.offer(566);
		pq.offer(12);
		pq.offer(0);
		
		System.out.println(pq);
		
		// now, because we added a Comparator implementation, they exit in flipped order
		while (!pq.isEmpty())
			System.out.println(pq.poll());
		

	}

}

// implementing Comparable to provide a natural sorting order for this class
class Superhero implements Comparable<Superhero> {
	
	String name;
	int powerLevel;
	String archenemy;
	
	public Superhero(String name, int powerLevel, String archenemy) {
		super();
		this.name = name;
		this.powerLevel = powerLevel;
		this.archenemy = archenemy;
	}

	@Override
	public String toString() {
		return "Superhero [name=" + name + ", powerLevel=" + powerLevel + ", archenemy=" + archenemy + "]";
	}

	// this method returns an int
	// the exact value of the return doesn't matter
	// BUT whether it's negative, positive, or 0 will determine what happens when comparing it to another Superhero
	// our natural order will sort by power level
	@Override
	public int compareTo(Superhero o) {
		
		// here's the logic
//		if (this.powerLevel > o.powerLevel)
//			return 1;
//		else if (this.powerLevel < o.powerLevel)
//			return -1;
//		else
//			return 0;
		
		return o.powerLevel - this.powerLevel;
		
	}
	
}

// to sort by name, we implement Comparator in another class, then use that
class NameSorter implements Comparator<Superhero> {

	@Override
	public int compare(Superhero o1, Superhero o2) {
		
		// String has a compareTo method we can use for alphabetical ordering
		int result = o1.name.compareTo(o2.name);
		
		return result;
	}
	
}




