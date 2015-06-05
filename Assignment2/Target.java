/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	private static final double OUTER_CIRCLE_RADIUS = 72;
	private static final double MIDDLE_CIRCLE_RADIUS = 72 * 0.65;
	private static final double INNER_CIRCLE_RADIUS = 72 * 0.3;
	
	public void run() {
		drawOuterCircle();
		drawMiddleCircle();
		drawInnerCircle();
	}
	
	private void drawOuterCircle() {
		double x = (getWidth() - OUTER_CIRCLE_RADIUS * 2) / 2;
		double y = (getHeight() - OUTER_CIRCLE_RADIUS * 2) / 2;
		GOval outerCircle = new GOval (x, y, OUTER_CIRCLE_RADIUS * 2, OUTER_CIRCLE_RADIUS * 2);
		outerCircle.setFilled(true);
		outerCircle.setColor(Color.RED);
		add(outerCircle);
	}
	
	private void drawMiddleCircle() {
		double x = (getWidth() - MIDDLE_CIRCLE_RADIUS * 2) / 2;
		double y = (getHeight() - MIDDLE_CIRCLE_RADIUS * 2) / 2;
		GOval middleCircle = new GOval (x, y, MIDDLE_CIRCLE_RADIUS * 2, MIDDLE_CIRCLE_RADIUS * 2);
		middleCircle.setFilled(true);
		middleCircle.setColor(Color.WHITE);
		add(middleCircle);
	}
	
	private void drawInnerCircle() {
		double x = (getWidth() - INNER_CIRCLE_RADIUS * 2) / 2;
		double y = (getHeight() - INNER_CIRCLE_RADIUS * 2) / 2;
		GOval innerCircle = new GOval (x, y, INNER_CIRCLE_RADIUS * 2, INNER_CIRCLE_RADIUS * 2);
		innerCircle.setFilled(true);
		innerCircle.setColor(Color.RED);
		add(innerCircle);
	}
}
