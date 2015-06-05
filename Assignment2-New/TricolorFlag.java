/* Draws a tricolor flag.
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class TricolorFlag extends GraphicsProgram {
	/* The width and height of the flag. Many flags have an aspect ratio of 3:2 and
	 * our choice of constants here assumes this. Feel free to change these constants
	 * if you're drawing a flag with a different aspect ratio.
	 */
	private static final double FLAG_WIDTH  = 300;
	private static final double FLAG_HEIGHT = 200;
	
	// constants defining flag colors
	private static final Color FIRST_COLOR = new Color(0, 0, 0);
	private static final Color SECOND_COLOR = new Color(255, 255, 0);
	private static final Color THIRD_COLOR = new Color(255, 0, 0);
	
	public void run() {
		double width = getWidth();
		double height = getHeight();
		
		// top-right co-ordinates of the flag
		double x = (width - FLAG_WIDTH) / 2;
		double y = (height - FLAG_HEIGHT) / 2;
		
		// compute x co-ordinate for each portion of flag
		double x1 = x;
		double x2 = x + FLAG_WIDTH / 3;
		double x3 = x + 2 * FLAG_WIDTH / 3;
		
		// draw rectangles
		GRect flagFirst = new GRect(x1, y, FLAG_WIDTH / 3, FLAG_HEIGHT);
		flagFirst.setFilled(true);
		flagFirst.setColor(FIRST_COLOR);
		add(flagFirst);
		
		GRect flagSecond = new GRect(x2, y, FLAG_WIDTH / 3, FLAG_HEIGHT);
		flagSecond.setFilled(true);
		flagSecond.setColor(SECOND_COLOR);
		add(flagSecond);
		
		GRect flagThird = new GRect(x3, y, FLAG_WIDTH / 3, FLAG_HEIGHT);
		flagThird.setFilled(true);
		flagThird.setColor(THIRD_COLOR);
		add(flagThird);
		
		// draw label
		GLabel label = new GLabel("Flag of Belgium");
		label.setFont("Times New Roman-30");
		double xFont = (width - label.getWidth());
		double yFont = (height - label.getDescent());
		add(label, xFont, yFont);
	}
}
