/* Draws a box optical illusion
 */
import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class BoxesIllusion extends GraphicsProgram {
	/* The number of rows and columns in the grid, respectively. */
	private static final int NUM_ROWS = 5;
	private static final int NUM_COLS = 6;
	
	/* The width and height of each box. */
	private static final double BOX_SIZE = 40;
	
	/* The horizontal and vertical spacing between the boxes. */
	private static final double BOX_SPACING = 10;
	
	/* The default width and height of the window. These constants will tell Java to
	 * create a window whose size is *approximately* given by these dimensions. You should
	 * not directly use these constants in your program; instead, use getWidth() and
	 * getHeight().
	 */
	public static final int APPLICATION_WIDTH = 350;
	public static final int APPLICATION_HEIGHT = 300;

	public void run() {
		double width = getWidth();
		double height = getHeight();
		
		double illusionWidth = NUM_COLS * BOX_SIZE + (NUM_COLS - 1) * BOX_SPACING;
		double illusionHeight = NUM_ROWS * BOX_SIZE + (NUM_ROWS - 1) * BOX_SPACING;
		
		double xOffset = (width - illusionWidth) / 2;
		double yOffset = (height - illusionHeight) / 2;
		
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				double xBox = xOffset + j * (BOX_SIZE + BOX_SPACING);
				double yBox = yOffset + i * (BOX_SIZE + BOX_SPACING);
				
				GRect box = new GRect(xBox, yBox, BOX_SIZE, BOX_SIZE);
				box.setFilled(true);
				box.setColor(Color.BLACK);
				add(box);
			}
		}
	}
}
