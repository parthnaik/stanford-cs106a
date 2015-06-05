/*
 * Draws the face of a robot in the center of the screen
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 300;
	private static final int EYE_RADIUS = 20;
	private static final int MOUTH_WIDTH = 120;
	private static final int MOUTH_HEIGHT = 40;
	
	public void run() {
		double width = getWidth();
		double height = getHeight();
		
		// draw head
		double xHead = width / 2 - HEAD_WIDTH / 2;
		double yHead = height / 2 - HEAD_HEIGHT / 2;
		GRect head = new GRect(xHead, yHead, HEAD_WIDTH, HEAD_HEIGHT);
		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		add(head);
		
		// calculate eye co-ordinates
		double yEyes = yHead + HEAD_HEIGHT / 4 - EYE_RADIUS;
		double xLeftEye = xHead + HEAD_WIDTH / 4 - EYE_RADIUS;
		double xRightEye = xHead + 3 * HEAD_WIDTH / 4 - EYE_RADIUS;
		
		// draw eyes
		GOval leftEye = new GOval(xLeftEye, yEyes, EYE_RADIUS * 2, EYE_RADIUS * 2);
		leftEye.setFilled(true);
		leftEye.setColor(Color.YELLOW);
		add(leftEye);
		
		GOval rightEye = new GOval(xRightEye, yEyes, EYE_RADIUS * 2, EYE_RADIUS * 2);
		rightEye.setFilled(true);
		rightEye.setColor(Color.YELLOW);
		add(rightEye);
		
		// draw mouth
		double xMouth = xHead + HEAD_WIDTH / 2 - MOUTH_WIDTH / 2;
		double yMouth = yHead + 3 * HEAD_HEIGHT / 4 - MOUTH_HEIGHT / 2;
		GRect mouth = new GRect(xMouth, yMouth, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}
}
