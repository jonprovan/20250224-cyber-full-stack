package com.skillstorm;

public class ArgumentsToMain {
	
	// when we run from the command line or provide arguments via Spring Tool Suite
	// they get lumped into the args variable, and we then have access
	// to provide arguments in Eclipse -- right-click class > Properties > Run/Debug Settings > Edit > Arguments Tab > Program arguments
	public static void main(String[] args) throws Exception {
		
		// seeing what our arguments are
		for (String a : args) {
			System.out.println(a);
		}
		
		// perhaps we run a different set of code if we're in dev vs. prod
		// also safeguarding here against non-dev/prod values and empty args arrays
		
		if (args.length > 0 && args[0].equals("dev"))
				System.out.println("We are in development at the moment.");
		else if (args.length > 0 && args[0].equals("prod"))
			System.out.println("We are now in production!");
		else
			throw new Exception("BUSTED!!");
		
	}

}
