// this class is in the default package, so it has no package declaration

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class TeamMaker {

	// we have a couple "yellow-squiggly" moments that Java suggests we fix but will still compile
	// this annotation removes those particular squigglies, but if you can get rid of them by refactoring, it's usually a better option
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		// OBJECTIVES
		
		/*
		 * 1. create a collection of all your names
		 * 2. create 4 teams, which will eventually hold 2 people each
		 * 3. randomly place people in the teams until all 8 people are placed
		 */
		
		// random numbers
		// a few ways to do this, but one is using Java's Random class
		Random random = new Random();
		
		// this will generate a random int between 0 and 10, inclusive of 0, exclusive of 10
		int randomNumberOne = random.nextInt(10);
		
		System.out.println(randomNumberOne);
		
		// quick LinkedList implementation
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(5);
		list.add(34);
		list.add(99);
		list.add(0);
		
		System.out.println(list);
		
		list.remove(2);
		
		System.out.println(list);
		
		/*
		 * 1. create a collection of all your names
		 * 2. create 4 teams, which will eventually hold 2 people each
		 * 3. randomly place people in the teams until all 8 people are placed
		 */
		
		// step through the teams, randomly selecting a member until we're out of members
		
		// a shorthand for adding multiple elements at instantiation
		LinkedList<String> ogList = new LinkedList<>(Arrays.asList("Liam", "Leah", "Malykai", "Nikash", "Muhiddin", "Sebastian", "Dhruv", "Jordan"));
		
//		System.out.println(ogList);
		
		LinkedList<String> team1 = new LinkedList<>();
		LinkedList<String> team2 = new LinkedList<>();
		LinkedList<String> team3 = new LinkedList<>();
		LinkedList<String> team4 = new LinkedList<>();
		
		LinkedList[] teams = { team1, team2, team3, team4 };
		
//		System.out.println(ogList.size());
		
		
//		while (!ogList.isEmpty()) {
//			int index = new Random().nextInt(ogList.size());
//		}
		
		// refactoring as a for loop so we can % the index for team selection
		for (int i = 0; i < 8; i++) {
//			int index = new Random().nextInt(ogList.size());
//			String name = ogList.remove(index);
//			
//			int teamSelection = i % 4;
//			teams[teamSelection].add(name);
			
			// does the same thing as the above in one statement
			// less readable/clear but shorter
			// also technically requires less resource usage, as we don't have variables allocated
			// not a significant factor at this scale
			teams[i%4].add(ogList.remove(new Random().nextInt(ogList.size())));
		}
		
		System.out.println(Arrays.toString(teams));
		
		

	}

}
