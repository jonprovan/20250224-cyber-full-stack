package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreading {

	public static void main(String[] args) {
		
		// MULTITHREADING IN JAVA
		
		/*
		 * Java is multi-threaded, meaning it's capable of handling more than one thing at the same time
		 * Your device has a certain number of threads available
		 * These threads are shared between Java and whatever else is running on your device
		 * Which thread is acting at any given time is not something you can control!
		 * Code actions occur by default in an unpredictable order
		 */
		
		// creating a Thread using our Runnable-implementing class
		// Runnable is a Functional Interface that we've implemented and implemented its run method with something to do
		Thread thread = new Thread(new ThingToRun("My First Thread"));
		
		// if I run the run method, it'll work, but the Thread will not actually generate a separate thread from main
//		thread.run();
		
		// to actually execute the Thread in a new thread, we use start()
//		thread.start();
		
		// .join() will wait for this thread to finish before moving on
		// if we want to ensure that later code in the main method executes after this, we need .join()
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		System.out.println();
		
		// these actions do not take place in any predictable order, even from run to run
		List<Thread> threads = new ArrayList<>();
		
		for (int x = 1; x < 4; x++) {
			Thread t = new Thread(new NumberPrinter("T" + x));
			threads.add(t);
		}
		
//		for (Thread t : threads)
//			t.start();
//		
//		for (Thread t : threads)
//			try {
//				t.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		
//		System.out.println();
		
		// this problem is worse with shared resources
		List<Thread> counterThreads = new ArrayList<>();
		
		for (int x = 0; x < 5; x++) {
			Thread t = new Thread(new Counter("T" + (x + 1)));
			counterThreads.add(t);
		}
		
		for (Thread t : counterThreads)
			t.start();
		
		for (Thread t : counterThreads)
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		// we need some method to control execution order
		// or, at the very least, make sure certain things can't happen before others
		
		// can create a Runnable like this...
		Runnable r = new Runnable() {
			@Override
			public void run() {}
		};
		
		//...or even shorter, like this:
		Runnable r2 = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("...nap over!");
		};
		
//		Thread sleepyThread = new Thread(r2);
//		sleepyThread.start();
		

	}

}

// creating a Runnable-implementing class
class ThingToRun implements Runnable {
	
	String name;
	
	public ThingToRun(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " is running!");
	}
	
}

class NumberPrinter implements Runnable {
	
	static List<Integer> nums = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
	
	String name;
	
	public NumberPrinter(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		
		for (Integer num : nums)
			System.out.println("Thread " + name + ": " + num);
		
	}
	
}

// this class will use three different ways of restricting which thread can execute the code at any given time
class Counter implements Runnable {
	
	static int count;
	
	String name;
	
	public Counter(String name) {
		this.name = name;
	}
	
	// OPTION 1: a Lock object
	// we want there to be only one, so we make it static
	static Lock lock = new ReentrantLock();
	
	// OPTION 2: call to an external synchronized method
	// a synchronized method can only be executed by one thread at a time
	// these have have be static as well, because otherwise each Runnable will have its own
	// if we wish to have thread-specific data in there, we have to pass it from the run method in
	public static synchronized void syncAction(String name) {
		System.out.println(name + ": " + count);
		count++;
	}

	@Override
	public void run() {
		
//		OPTION 1
//		for (int i = 0; i < 5; i++) {
			
			// once a thread locks the lock, no other thread can progress past this point
//			lock.lock();
			
//			System.out.println(count);
//			count++;
			
			// after a thread unlocks the lock, other threads can move into the code block
//			lock.unlock();
			
//		}
		
//		OPTION 2
//		for (int i = 0; i < 5; i++) {
//			syncAction(this.name);
//		}
		
//		OPTION 3 (see other class)
		for (int i = 0; i < 5; i++) {
			
			synchronized(Mutex.getMutex()) {
				System.out.println(count);
				count++;
			}
			
		}
	}

}

// OPTION 3
// use a Mutex!
// short for Mutually Exclusive
// a Mutex is some sort of object that, when one Thread is "holding onto it", it's the only one that can do something
// this is a good spot to employ the Singleton pattern
// a Singleton is a Java class of which you can only ever instantiate ONE object
class Mutex {
	
	// static variable holding the single instance
	private static Mutex mutex;
	
	// private constructor
	// no one outside can create a Mutex
	private Mutex() {}
	
	// public static method to return an instance of the class
	// need to synchronize this method as well
	// it's possible two threads could see a null mutex, create two separate ones, and make it into the block
	public static synchronized Mutex getMutex() {
		if (mutex == null)
			mutex = new Mutex();
		return mutex;
	}
	
}