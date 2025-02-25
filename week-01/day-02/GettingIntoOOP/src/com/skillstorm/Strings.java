package com.skillstorm;

public class Strings {

	public static void main(String[] args) {
		
		// STRINGS IN JAVA
		
		/*
		 * Strings are Objects in Java
		 * they are arrays of chars
		 * to check equality, we have to (sometimes) use different methodology to see if two Strings match
		 * 
		 */
		
		String myString1 = "abcde";
		String myString2 = new String("fghij");
		String myString3 = myString1 + myString2;
		
		System.out.println(myString3);
		
		String myString4 = myString3 + 123;
		
		System.out.println(myString4);
		
		Object o = new Object();
		
		String myString5 = myString4 + o;
		System.out.println(myString5);
		
		// many useful methods we can employ when using strings
		System.out.println(myString5.charAt(10));
		System.out.println(myString5.contains("Object"));
		
		// substring takes a chunk of a String and returns it to a new String
		// if one parameter, it takes from there until the end
		// if two, it stops at the second index (exclusive)
		String myString6 = myString5.substring(7, 14);
		
		System.out.println(myString6);
		
		// equality with Strings
		// ALWAYS use the .equals() method for Strings
		System.out.println("abc" == "abc"); // true
		System.out.println(new String("abc") == new String("abc")); // false, because different Objects
		System.out.println(new String("abc").equals(new String("abc"))); // true
		System.out.println(new String("abc").equals("abc")); // true
		System.out.println("abc".equals("abc")); // true
		
		// Strings can use escape characters where needed
		// generally, any character with a \ before it will be treated as part of the String
		// plus, there are some special characters we can use, like \n for a line break
		System.out.println("I'd like to say \"Hello!\" to you right now.");
		System.out.println("Line One \n Line Two \n  Line Three");
		
		System.out.print("One\nTwo\nThree");
		
		

	}

}
