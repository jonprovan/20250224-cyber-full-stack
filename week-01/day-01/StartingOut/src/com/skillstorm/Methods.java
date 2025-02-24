package com.skillstorm;

// you can ONLY have one public class per file, but you CAN have more than one class
public class Methods {

	// static methods can only access other static things without instantiating an object
	// we'll use static methods here a lot
	// HOWEVER, most of your methods going forward will be non-static
	public static void main(String[] args) {
		
		// METHODS IN JAVA (functions)
		
		/*
		 * <access modifier> <other modifier(s)> <return type> <name> ( <optional parameters> ) { <logic>, <optional return> }
		 * 
		 * methods can call other methods
		 * 
		 * ACCESS MODIFIERS
		 * public -- anywhere in the program
		 * protected -- anything in the current package AND subclasses in different packages
		 * default (no modifier) -- anything in the current package
		 * private -- this class only
		 * 
		 * OTHER MODIFIERS
		 * static -- belongs to the class, NOT an instance
		 * final -- cannot be overridden in a subclass
		 * default -- in interfaces, you can create methods that have implementation
		 * 
		 * RETURN TYPE
		 * whatever the method returns to whichever method/line/moment called it OR void if there's no return
		 * 
		 * PARAMETERS
		 * we MUST type our parameters in Java, unlike JavaScript
		 * 
		 * RETURN
		 * if the return type is NOT void, you MUST return a value that matches the type
		 * you do NOT need a return statement in a void method
		 * BUT you CAN use "return" to exit the method
		 */
		
		System.out.println(addNum(1, 2));
		
		printName("Douglas Fairbanks, Esq.");
		
		System.out.println(addEm());
		
		// PASS-BY-VALUE vs. PASS-BY-REFERENCE
		
		int inGoing = 10;
		System.out.println(inGoing);
		
		System.out.println(addFive(inGoing));
		
		System.out.println(inGoing);
		
		OtherClass oc = new OtherClass(100);
		System.out.println(oc.num);
		
		addFiveToNum(oc);
		
		System.out.println(oc.num);

	}
	
	// method names are camelCase in Java
	// to call this method directly from main, it has to be static, since main is static
	public static int addNum(int x, int y) {
		return x + y;
	}
	
	public static void printName(String name) {
		if (name.equals("Douglas Fairbanks"))
			return;
		
		System.out.println(name);
	}
	
	public static int getTen() {
		return 10;
	}
	
	public static int getTwenty() {
		return 20;
	}
	
	public static int addEm() {
		return getTen() + getTwenty();
	}
	
	public static int addFive(int x) {
		x = x + 5;
		return x;
	}
	
	public static void addFiveToNum(OtherClass o) {
		o.num = o.num + 5;
		// this ONLY nulls out the o reference to the object, not the original oc reference from the main method
		// so, the object still exists with the changed values
		o = null;
	}

}

class OtherClass {
	int num;
	
	public OtherClass(int num) {
		this.num = num;
	}
}
