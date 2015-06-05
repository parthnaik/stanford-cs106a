/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int SENTINEL = 0;
	
	public void run() {
		int smallest, largest;
		smallest = largest = 0;
		
		println("This program calculates the largest and smallest numbers. Enter 0 to stop.");
		
		while (true) {
			int input = readInt("? ");
			if (input == SENTINEL) break;
			
			if (input < smallest || smallest == 0) smallest = input;
			if (input > largest || largest == 0) largest = input;
		}
		
		println("Smallest = " + smallest);
		println("Largest = " + largest);
	}
}

