package com.skillstorm;

public class TernaryFun {

	public static void main(String[] args) {
		
		// SOME WACKY TERNARIES!
		
		int x = (1 < 2) ? 3 : 4;
		System.out.println(x);
		
		char y = (5 < 7) ? (4 > 9) ? 'a' : 'b' : 'c';
		
		System.out.println(y);
		
		// one way of parsing these is to look for the complete ternary statements within that are resolvable
		char z = (1 == 0 && 3 * 2 == 6) ? 'a' : (4 / 2 == 2 && 5 <= 3) ? 'b' : (4 < 1) ? 'c' : 'd';
//			 z = (1 == 0 && 3 * 2 == 6) ? 'a' : (4 / 2 == 2 && 5 <= 3) ? 'b' : 'd';
//			 z = (1 == 0 && 3 * 2 == 6) ? 'a' : 'd';
//			 z = 'd';
		
		System.out.println(z);

	}

}
