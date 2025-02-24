// this is a comment in Java that will not run

// this is a package declaration
// it MUST come before the class
package com.skillstorm;

// if we have imports, they MUST come AFTER the package declaration and BEFORE the class
import java.util.*;

// this is a class declaration -- <access modifier> class <class name in PascalCase
public class HelloWorld {
	
	/**
	 * SOME NOTES ABOUT JAVA
	 * 
	 * Object-Oriented programming language
	 * JRE/JVM/JDK
	 * Java Runtime Environment
	 * Java Virtual Machine -- anything compiled in Java can be run on ANY JVM
	 * Java Development Kit
	 * Automatic memory management via garbage collection
	 * Many purposes/functions -- games, big data, mobile, web dev
	 * Multi-threaded
	 * 
	 * Whitespace does not matter in Java! (including line breaks, etc.)
	 */
	
	// the main method is the starting point for our application
	// whichever class we "run", that class's main method will be where we begin
	// <access modifier> <other modifiers> <return type> main(String[] args) {}
	public static void main(String[] args) {
		
		// public static void main(String args[]) {} -- this also works, and some other variations
		System.out.println("Did it work?");
		System.out.println("Hello, World!!");
		System.out.println("Use the macro sysout, then Ctrl-Space to get a print line");
		
		// double-quotes in Java are Strings, single-quotes are chars
		
		boolean isTrue = true;
		
		System.out.println(isTrue);
		
	}

}
