import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram {
	public void run() {
		addMouseListeners();
	}
	
	private GLine line;
	private double x, y;
	
	/** The mouseDragged event is always triggered after the mousePressed event
	 * since the user always clicks first.
	 */
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		line = new GLine(x, y, x, y);
		add(line);
	}
	
	public void mouseDragged(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		// the setEndPoint method only changes the lines endPoint without affecting startPoint
		line.setEndPoint(x, y);
	}
}
