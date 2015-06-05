/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		int current = 1;
		
		while (frontIsClear()) {
			if ((current - 1) % 4 == 0) {
				fixColumn();
			}
			
			moveToNextColumn(current);
		}
		
		if ((current - 1) % 4 == 0) {
			fixColumn();
		}
	}
	
	private void fixColumn() {
		buildColumn();
		returnToStart();
	}
	
	private void buildColumn() {
		if (noBeepersPresent()) {
			putBeeper();
		}
		
		turnLeft();
		
		while (frontIsClear()) {
			move();
			
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}
	
	private void returnToStart() {
		turnAround();
		
		while (frontIsClear()) {
			move();
		}
		
		turnLeft();
	}
	
	private void moveToNextColumn(int current) {
		for (int i = 0; i < 4; i++) {
			if (frontIsClear()) {
				move();
				current++;
			}
		}
	}
}
