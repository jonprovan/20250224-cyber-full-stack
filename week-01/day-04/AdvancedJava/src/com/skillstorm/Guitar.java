package com.skillstorm;

// making this class abstract so we can't make a generic guitar
// making it public because the end user WILL need to know the concept of what a guitar is
abstract public class Guitar {
	
	String make;
	String model;
	int numberOfStrings;
	boolean acoustic;
	int year;
	double cost;
	String toneWood;
	
	Guitar(String make, String model, int numberOfStrings, boolean acoustic, int year, double cost, String toneWood) {
		super();
		this.make = make;
		this.model = model;
		this.numberOfStrings = numberOfStrings;
		this.acoustic = acoustic;
		this.year = year;
		this.cost = cost;
		this.toneWood = toneWood;
	}
	
}

class Stratocaster extends Guitar {
	
	Stratocaster() {
		super("Fender", "Stratocaster", 6, false, 2024, 1499.99, "Alder");
	}

	@Override
	public String toString() {
		return "Stratocaster [make=" + make + ", model=" + model + ", numberOfStrings=" + numberOfStrings
				+ ", acoustic=" + acoustic + ", year=" + year + ", cost=" + cost + ", toneWood=" + toneWood + "]";
	}
	
}

class Talman extends Guitar {
	
	Talman() {
		super("Ibanez", "Talman", 6, false, 2025, 299.99, "Ash");
	}

	@Override
	public String toString() {
		return "Talman [make=" + make + ", model=" + model + ", numberOfStrings=" + numberOfStrings
				+ ", acoustic=" + acoustic + ", year=" + year + ", cost=" + cost + ", toneWood=" + toneWood + "]";
	}
	
}

class D18E extends Guitar {
	
	D18E() {
		super("Martin", "D18E", 6, true, 1980, 5999999.99, "Spruce");
	}

	@Override
	public String toString() {
		return "D18E [make=" + make + ", model=" + model + ", numberOfStrings=" + numberOfStrings
				+ ", acoustic=" + acoustic + ", year=" + year + ", cost=" + cost + ", toneWood=" + toneWood + "]";
	}
	
}













