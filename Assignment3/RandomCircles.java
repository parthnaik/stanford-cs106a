import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int CIRCLE_COUNT = 10;
	private static final int MIN_RADIUS = 5;
	private static final int MAX_RADIUS = 50;
	
	public void run() {
		for (int i = 0; i < CIRCLE_COUNT; i++) {
			drawCircle();
		}
	}
	
	private void drawCircle() {
		double radius = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
		double x = rgen.nextDouble(0, getWidth() - MAX_RADIUS * 2);
		double y = rgen.nextDouble(0, getHeight() - MAX_RADIUS * 2);
		GOval circle = new GOval(x, y, radius * 2, radius * 2);
		circle.setFilled(true);
		circle.setColor(rgen.nextColor());
		add(circle);
	}
}
