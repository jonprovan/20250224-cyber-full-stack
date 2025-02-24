package com.skillstorm;

public class Operators {

	public static void main(String[] args) {
		
		// OPERATORS IN JAVA
		
		/*
		 * mathematical operations, assignment, logical/relational operators, comparison, incremental
		 * 
		 * MATHEMATICAL
		 * +
		 * -
		 * *
		 * /
		 * %
		 * = -- assignment operator
		 * 
		 * bit-shifting
		 * 
		 * PEMDAS applies! 1 + 2 * 3
		 * 
		 * 
		 * INCREMENTAL
		 * -- these ONLY work with variables, not primitive values, so i++, not 6++
		 * ++
		 * --
		 * careful of prefix/postfix -- i++ different from ++i
		 * += -- x = x + 5 same as x += 5
		 * -=
		 * *=
		 * /=
		 * %=
		 * 
		 * 
		 * COMPARISON
		 * -- these return boolean values
		 * >
		 * <
		 * <=
		 * >=
		 * == -- there is no === in Java, because Java is strongly-typed, so two things of different types are NEVER equal
		 * != -- not equal
		 * !
		 * 
		 * 
		 * LOGICAL/RELATIONAL
		 * &&
		 * ||
		 * & -- bitwise AND
		 * | -- bitwise OR
		 * ^ -- XOR, 
		 * !(a || b) -- NOR
		 * !(a && b) -- NAND
		 * !^ -- look into this one...
		 * 
		 * generally speaking, math/inc first, then comparison, then logical
		 * 
		 */
		
		System.out.println(5 > 1 && 6 < 2 || 66 % 2 == 0);
		
		// the double versions shorthand it by NOT evaluating the righthand side if the left answers the question already
		System.out.println(false && true);
		System.out.println(true || false);
		
		BooleanTest bt = new BooleanTest();
		
		bt = null;
		
		// using a single &, this would throw a NullPointerException, because we're trying to access a property of a null object
		// even though the first check makes the statement false, we check it anyway with &
		if (bt != null && bt.num == 10) {
			System.out.println("Success!");
		}

	}

}

class BooleanTest {
	int num = 10;
}
