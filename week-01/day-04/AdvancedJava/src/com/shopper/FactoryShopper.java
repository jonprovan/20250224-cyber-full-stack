package com.shopper;

import com.skillstorm.Guitar;
import com.skillstorm.GuitarFactory;

public class FactoryShopper {

	public static void main(String[] args) throws Exception {
		
		// this class will attempt to access and use our GuitarFactory
		
		// can't do this, because it's abstract
//		Guitar guitar = new Guitar();
		
		// can't do this, either, because Stratocaster is not available to this package
//		Guitar guitar = new Stratocaster();
		
		// CAN do this, because the Guitar class is public
		// BUT, if I want to fill it, I have to use my Factory methods
		Guitar guitar;
		
		// the Factory methods in fact return instances of the specific types we cannot create directly here
		guitar = GuitarFactory.getGuitarByPrice(2000);
		
		System.out.println(guitar);
		
		// checking the actual type
		System.out.println(guitar.getClass());
		
		Guitar ibanez = GuitarFactory.getGuitarByPrice(500);
		System.out.println(ibanez);
		
		Guitar martin = GuitarFactory.getGuitarByModel("D18E");
		System.out.println(martin);
		
		Guitar random = GuitarFactory.getGuitarByModel("abc");
//		Guitar random = GuitarFactory.getGuitarByPrice(0);

	}

}
