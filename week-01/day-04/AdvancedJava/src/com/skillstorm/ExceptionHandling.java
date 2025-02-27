package com.skillstorm;

import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		// EXCEPTION HANDLING IN JAVA
		
		/*
		 * Errors are problems we generally cannot recover from
		 * Exceptions are ones we can -- and should! (if it makes sense)
		 * 
		 * Both are objects in Java
		 * 
		 * You can create your own custom Exceptions to use for specific purposes
		 * 
		 * When handling Exceptions, we have a few options:
		 * - try / catch -- attempt some code, and if it throws, do something with the Exception
		 * - simply throw the Exception and break the program
		 * - throw the Exception to the caller and have the caller (or the caller's caller, etc.) handle it there
		 */
		
		// using try/catch
		// this will throw, so we want to catch it
//		int x = 1/0;
		
		// you can have as many catch blocks as you like to catch different exceptions
		try {
			Object o = null;
			System.out.println(o.toString());
			int x = 1/0;
		// whatever Exception type you put in the catch, it'll catch that type and ALL CHILD CLASSES
		// you can break them out, like this:
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		// or you can group them together like this
//		catch (ArithmeticException | NullPointerException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("Did we get here?");
		
		// if you have multiple catches with Exceptions in a hierarchy, you must catch them from most -> least specific
		// otherwise, the more generic catch will grab it, and the other blocks won't be reachable
		try {
			throw new RuntimeException();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException Caught");
			
			// if we do this, it'll actually break and not get caught by subsequent catches
			// those catches are for the original try
			// we'd have to try/catch again for this issue
//			throw new RuntimeException("Yikes!!");
		} catch (RuntimeException e) {
			System.out.println("RuntimeException Caught");
		} catch (Exception e) {
			System.out.println("Exception Caught");
		// the finally block will run ALWAYS if we make it to the try
		// even if there's an uncaught Exception/Error within the try or one of the catches
		// unless the system literally somehow shuts down before processing can continue
		// this can be useful for logging error handling results
		// or closing connections/resources when not using a try-with-resources structure
		} finally {
			System.out.println("FINALLY!!");
		}
		
		System.out.println("How about here?");
		
		// try-with-resources
		// we can create temporary resources that get automatically eliminated at the end of the try
		// we don't have to manually get rid of the object
		// this can be useful for File I/O, connections, etc.
		try (MyAutoCloseable mac = new MyAutoCloseable()) {
			System.out.println(mac);
		} catch (IOException e) {
			// can't do this, because it already vanished
//			System.out.println(mac);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// can't do this, either
//		System.out.println(mac);
		
		MyAutoCloseable mac = new MyAutoCloseable();
		
		try {
//			MyAutoCloseable mac = new MyAutoCloseable();
			throw new Exception();
		} catch (Exception e) {
			// I don't have access to it here, BUT it hasn't been closed
			System.out.println(mac);
		} finally {
			try {
				mac.close();
			} catch (Exception e) {
				
			}
		}
		
		
		// handling Exceptions from other places
		// it's often useful to handle several exceptions in one spot, rather than spreading handling code all about
		// the handleExceptions() method takes care of one of the two
		// but we passed the other one up to here
		// as long as they're all handled before throwing in the main method, you're good!
		try {
			handleExceptions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// checked vs. unchecked exceptions
		// RuntimeExceptions are unchecked, meaning the compiler won't know about them or force you to handle them
		// other Exceptions, you'll be forced to deal with
		
		// all of these generate RuntimeExceptions that aren't checked
//		int y = 1/0;
//		int[] nums = { 1, 2, 3 };
//		System.out.println(nums[10]);
//		Object o = null;
//		System.out.println(o.toString());
		
		// throw new RuntimeException(); // doesn't even care about this!
		// throw new IOException(); // but for this, it'll tell you
		
	}
	
	
	
	
	// we could handle multiple exceptions here (later code)
	// for now, we're still passing one up to the main method
	public static void handleExceptions() throws IOException {
		
		try {
			throwOne();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} finally {
			System.out.println("CCEs handled!");
		}
		
		// we can also pass the buck up to the caller again, if we like
		throwTwo();

//			
//			throwTwo();
//			
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
		
	}
	
	public static void throwOne() throws ClassCastException {
		throw new ClassCastException("Shouldn't have cast that class...");
	}
	
	public static void throwTwo() throws IOException {
		throw new IOException("That I/O is WAAAACK.");
	}

}

class MySpecialException extends IOException {
	
}

// something to use with our try-with-resources block; must implement this to work
class MyAutoCloseable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}


