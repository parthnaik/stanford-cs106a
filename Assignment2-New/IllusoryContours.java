/* Replace these file comments with a description of what your program
 * does.
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class IllusoryContours extends GraphicsProgram {
	/* The default width and height of the window. These constants will tell Java to
	 * create a window whose size is *approximately* given by these dimensions. You should
	 * not directly use these constants in your program; instead, use getWidth() and
	 * getHeight(), which return the *exact* width and height of the window.
	 */
	public static final int APPLICATION_WIDTH = 300;
	public static final int APPLICATION_HEIGHT = 300;
	
	// radius of circles
	private static final int DIAMETER = 100;
	
	public void run() {
		int width = getWidth();
		int height = getHeight();
		
		GOval circleTopLeft = new GOval(0, 0, DIAMETER, DIAMETER);
		circleTopLeft.setFilled(true);
		add(circleTopLeft);
		
		GOval circleBottomLeft = new GOval(0, height - DIAMETER, DIAMETER, DIAMETER);
		circleBottomLeft.setFilled(true);
		add(circleBottomLeft);
		
		GOval circleTopRight = new GOval(width - DIAMETER, 0, DIAMETER, DIAMETER);
		circleTopRight.setFilled(true);
		add(circleTopRight);
		
		GOval circleBottomRight = new GOval(width - DIAMETER, height - DIAMETER, DIAMETER, DIAMETER);
		circleBottomRight.setFilled(true);
		add(circleBottomRight);
		
		GRect rectangle = new GRect(DIAMETER / 2, DIAMETER / 2, width - DIAMETER, height - DIAMETER);
		rectangle.setFilled(true);
		rectangle.setColor(Color.WHITE);
		add(rectangle);
	}
}
