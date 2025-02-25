package com.skillstorm;

public class Polymorphism {

	public static void main(String[] args) {
		
		// POLYMORPHISM IN JAVA
		
		/*
		 * "many forms"
		 * overriding
		 * overloading
		 * covariance
		 */
		
		Polly p = new Polly();
		
		p.speak();
		p.speak(6);
		p.speak("a");
		p.speak(3, 4);
		p.speak(7, "b");
		p.speak("c", 23);
		
		SuperC s1 = new SuperC();
		SuperC s2 = new SubC();
		SuperC s3 = new SubSubC();
		
		// regardless of the reference type, when running an overridden method
		// the most specific method will run
		// put another way, the method associated with the ACTUAL object type will run
		s1.talk();
		s2.talk();
		s3.talk();

	}

}

class Polly {
	
	// overloading is having a different set of parameters but the same method name
	void speak() {
		System.out.println("No args");
	}
	
	// this doesn't work, because I didn't change the number/type of parameters
	// the return type can change to whatever, but it doesn't affect whether it can be overloaded or not
//	int speak() {
//		return 1;
//	}
	
	// each of these has a different parameter structure
	// as long as something about the number/type/order of the params is different, you're good
	void speak(int arg) {
		System.out.println("One int arg");
	}
	
	void speak(String arg) {
		System.out.println("One String arg");
	}
	
	void speak(int arg1, int arg2) {
		System.out.println("Two int args");
	}
	
	void speak(int arg1, String arg2) {
		System.out.println("One int and one String arg");
	}
	
	void speak(String arg1, int arg2) {
		System.out.println("One String and one int arg");
	}
	
}

// note the access modifiers
// you CAN increase visibility from a class to a subclass on an overridden method
// you CANNOT decrease it an any subclass
class SuperC {
	
	void talk() {
		System.out.println("I am a SuperC");
	}
}

class SubC extends SuperC {
	
	@Override
	protected void talk() {
		System.out.println("I am a SubC");
	}
}

class SubSubC extends SubC {
	
	@Override
	public void talk() {
		System.out.println("I am a SubSubC");
	}
}







