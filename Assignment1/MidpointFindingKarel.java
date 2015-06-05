/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		int length = findLengthOfStreet();
		int midpoint = findMidpoint(length);
		goToMidpoint(length, midpoint);
		putBeeper();
	}
	
	private int findLengthOfStreet() {
		int length = 1;
		
		while (frontIsClear()) {
			move();
			length++;
		}
		
		return length;
	}

	private int findMidpoint(int length) {
		int midpoint = (length + 1) / 2;
		
		return midpoint;
	}
	
	private void goToMidpoint(int length, int midpoint) {
		turnAround();
		int stepback = length - midpoint;
		
		for (int i = 0; i < stepback; i++) {
			move();
		}
		
		turnAround();
	}
}
