/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		// Calculate the size of brick structure
		int numberOfRows = BRICKS_IN_BASE;
		int brickStructureWidth = BRICKS_IN_BASE * BRICK_WIDTH;
		int brickStructureHeight = numberOfRows * BRICK_HEIGHT;
		
		// pixel point at which base brick structure begins
		double baseBrickStartPoint = (getWidth() - brickStructureWidth) / 2;
		
		// draw bricks
		for (int i = 0; i < numberOfRows; i++) {
			// calculate first brick's x, y coordinate for particular row
			int noOfBricksInRow = i + 1;
			int brickRowWidth = i * BRICK_WIDTH;
			int brickX = (getWidth() - brickRowWidth) / 2;
			int brickY = getHeight() - (BRICK_HEIGHT * (numberOfRows - i));
			
			for (int j = 0; j < i + 1; j++) {
				GRect brick = new GRect(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
				add(brick);
				brickX += BRICK_WIDTH;
			}
		}
	}
}

