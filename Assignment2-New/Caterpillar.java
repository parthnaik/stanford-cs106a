/* Draws a caterpillar of variable body segments and color.
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Caterpillar extends GraphicsProgram {
	/* TODO: You are probably going to want to define some program constants here that
	 * control the size, number, spacing, and color of the body segments. When you do,
	 * delete this comment and replace it with your constants.
	 * 
	 * Remember to add comments describing what each constant does!
	 */	
	
	public static final int NO_OF_SEGMENTS = 6;
	public static final int SEGMENT_DIAMETER = 100;
	public static final int HORIZONTAL_SPACING = 60;
	public static final int VERTICAL_SPACING = 50;
	
	public static final Color CATERPILLAR_COLOR = new Color(0, 255, 0);
	
	public void run() {		
		drawCaterpillar(170, 170);
	}
	
	private void drawCaterpillar(double x, double y) {
		for (int i = 0; i < NO_OF_SEGMENTS; i++) {
			double segmentX = x + i * HORIZONTAL_SPACING;
			double segmentY = y + (i % 2 == 0 ? 1 : 0) * VERTICAL_SPACING;
			
			GOval segment = new GOval(segmentX, segmentY, SEGMENT_DIAMETER, SEGMENT_DIAMETER);
			segment.setFilled(true);
			segment.setFillColor(CATERPILLAR_COLOR);
			add(segment);
		}
	}
}
