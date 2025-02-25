package com.other;

import com.skillstorm.Car;

public class TestHub {

	public static void main(String[] args) {
		
		Car car = new Car("Jeep", "Wrangler", 2010);
		
		System.out.println(car);
		
		// can't do this, because make is default-level access (only its package)
//		System.out.println(car.make);
		
		System.out.println(car.getYear());
		
		car.setYear(2015);
		
		System.out.println(car);
		
		// this will now throw an Exception, because the year is out of bounds
//		car.setYear(1900);
		
		System.out.println(car.isRad());
		
		car.setModel("Cherokee");
		
		System.out.println(car);

	}

}
