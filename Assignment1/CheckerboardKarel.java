/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
	public void run() {
		int cols = findNumberOfCols();
		int rows = findNumberOfRows();
		
		// case 1
		if (cols == 1) {
			turnLeft();
			placeBeepersOdd();
		}
		
		// case 2
		if (rows == 1) {
			placeBeepersOdd();
		}
		
		// case 3
		if (cols > 1 && rows > 1) {
			int currentRow = 1;
			
			for (int i = 0; i < rows; i++) {
				if (currentRow % 2 != 0) {
					placeBeepersOdd();
					returnToStart();
				} else {
					placeBeepersEven();
					returnToStart();
				}
				
				moveRowUp();
				currentRow++;
			}
		}
	}
	
	private void moveRowUp() {
		turnLeft();
		
		if (frontIsClear()) {
			move();
		}
		
		turnRight();
	}
	
	private int findNumberOfCols() {
		int cols = 1;
		
		while (frontIsClear()) {
			move();
			cols++;
		}
		
		returnToStart();
		
		return cols;
	}
	
	private int findNumberOfRows() {
		int rows = 1;
		turnLeft();
		
		while (frontIsClear()) {
			move();
			rows++;
		}
		
		returnToStart();
		turnRight();
		
		return rows;
	}
	
	private void returnToStart() {
		turnAround();
		
		while (frontIsClear()) {
			move();
		}
		
		turnAround();
	}
	
	private void placeBeepersOdd() {
		int current = 1;
		
		while (frontIsClear()) {
			if (current % 2 != 0) {
				putBeeper();
			}
			
			move();
			current++;
		}
		
		if (current %2 != 0) {
			putBeeper();
		}
	}
	
	private void placeBeepersEven() {
		move();
		placeBeepersOdd();
		
		/*int current = 1;
		
		while (frontIsClear()) {
			move();
			current++;
			
			if (current % 2 == 0) {
				putBeeper();
			}
		}*/
	}
}
