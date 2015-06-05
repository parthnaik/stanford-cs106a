/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final double RECT_WIDTH = 150;
	private static final double RECT_HEIGHT = 50;
	private static final double VERT_SPACING = 50;
	private static final double HOR_SPACING = 50;
	private static final double STRUCT_WIDTH = RECT_WIDTH * 3 + VERT_SPACING * 2;
	private static final double STRUCT_HEIGHT = RECT_HEIGHT * 2 + VERT_SPACING;
	
	public void run() {
		double upperBoxX = (getWidth() - RECT_WIDTH) / 2;
		double upperBoxY = (getHeight() - STRUCT_HEIGHT) / 2;
		
		double firstLowerBoxX = (getWidth() - STRUCT_WIDTH) / 2;
		double firstLowerBoxY = (getHeight() - STRUCT_HEIGHT) / 2 + RECT_HEIGHT + VERT_SPACING;
		
		double secondLowerBoxX = firstLowerBoxX + RECT_WIDTH + HOR_SPACING;
		double secondLowerBoxY = firstLowerBoxY;
		
		double thirdLowerBoxX = secondLowerBoxX + RECT_WIDTH + HOR_SPACING;
		double thirdLowerBoxY = firstLowerBoxY;
		
		drawBox(upperBoxX, upperBoxY, "Program");
		drawBox(firstLowerBoxX, firstLowerBoxY, "GraphicsProgram");
		drawBox(secondLowerBoxX, secondLowerBoxY, "ConsoleProgram");
		drawBox(thirdLowerBoxX, thirdLowerBoxY, "DialogProgram");
		
		drawLines();
	}
	
	private void drawBox(double x, double y, String text) {
		add(new GRect(x, y, RECT_WIDTH, RECT_HEIGHT));
        GLabel label = new GLabel(text);
        label.setFont("Times New Roman");
        double labelX = x + (RECT_WIDTH - label.getWidth()) / 2;
        double labelY = y + (RECT_HEIGHT / 2) + label.getAscent() / 2;
        label.setLocation(labelX, labelY);
        add(label);
	}
	
	private void drawLines() {
		double x1 = getWidth() / 2;
		double y1 = (getHeight() - STRUCT_HEIGHT) / 2 + RECT_HEIGHT;
		
		double x2 = (getWidth() - STRUCT_WIDTH) / 2 + RECT_WIDTH / 2;
		double y2 = (getHeight() - STRUCT_HEIGHT) / 2 + RECT_HEIGHT + VERT_SPACING;
		
		// draw 3 lines
		for (int i = 0; i < 3; i++) {
			GLine connector = new GLine(x1, y1, x2, y2);
			add(connector);
			x2 += RECT_WIDTH + VERT_SPACING;
		}
	}
}

