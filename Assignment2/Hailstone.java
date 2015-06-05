/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = 0;
		
		while (n < 1) {
			n = readInt("Pick a positive integer n to begin: ");
		}
		
		while (n != 1) {
			if (n % 2 == 0) {
				println(n + " is even, so I take half:\t" + itsEven(n));
				n = itsEven(n);
			} else {
				println(n + " is odd, so I take 3n+1:\t" + itsOdd(n));
				n = itsOdd(n);
			}
		}
	}
	
	private int itsEven(int n) {
		return n / 2;
	}
	
	private int itsOdd(int n) {
		return 3 * n + 1;
	}
}

