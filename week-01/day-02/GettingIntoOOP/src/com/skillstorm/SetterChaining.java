package com.skillstorm;

import java.util.Arrays;

public class SetterChaining {

	public static void main(String[] args) {
		
		// SETTER CHAINING IN JAVA

		String[] courses = { "Full-Stack", "DevOps", "Cybersecurity" };
		
		Student s = new Student("Dave", 36, courses);
		
		System.out.println(s);
		
		String[] courses2 = { "Full-Stack", "DevOps", "Cyber" };
		
//		s.setName("David");
//		s.setAge(37);
//		s.setCourses(courses2);
//		
		s.setName("David")
		 .setAge(37)
		 .setCourses(courses2);
		
		System.out.println(s);
	}

}

class Student {
	
	private String name;
	private int age;
	private String[] courses;
	
	public Student(String name, int age, String[] courses) {
		super();
		this.name = name;
		this.age = age;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	// to chain setters, we can return a Student object, specifically the one on which we're calling the setter
	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Student setAge(int age) {
		this.age = age;
		return this;
	}

	public String[] getCourses() {
		return courses;
	}

	public Student setCourses(String[] courses) {
		this.courses = courses;
		return this;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", courses=" + Arrays.toString(courses) + "]";
	}
	
	
	
}