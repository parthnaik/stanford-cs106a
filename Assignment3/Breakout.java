/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Pause time between animation */
	private static final int DELAY = 10;
	
/** Random number generator */
	private RandomGenerator rgen = RandomGenerator.getInstance();

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		for(int i = 0; i < NTURNS; i++) {
			setupGame();
			playGame();
			
			if(brickCounter == 0) {
				ball.setVisible(false);
				printWinner();
				break;
			}
			
			if (brickCounter > 0) {
				removeAll();
			}
		}
		
		if(brickCounter > 0) {
			printGameOver();
		}
	}
	
	private void setupGame() {
		drawBricks();
		drawBall();
		drawPaddle();
	}
	
	private void drawBricks() {
		double brickOffsetX = (APPLICATION_WIDTH - (NBRICKS_PER_ROW * BRICK_WIDTH + (NBRICKS_PER_ROW - 1) * BRICK_SEP)) / 2;
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				double x = j * (BRICK_WIDTH + BRICK_SEP) + brickOffsetX;
				double y = i * (BRICK_HEIGHT + BRICK_SEP) + BRICK_Y_OFFSET;
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				colorBrick(brick, i);
				add(brick);
			}
		}
	}
	
	private void colorBrick(GRect brick, int row) {
		row += 1;
		brick.setFilled(true);
		
		if (row == 1 || row == 2) {
			brick.setColor(Color.RED);
		} else if (row == 3 || row == 4) {
			brick.setColor(Color.ORANGE);
		} else if (row == 5 || row == 6) {
			brick.setColor(Color.YELLOW);
		} else if (row == 7 || row == 8) {
			brick.setColor(Color.GREEN);
		} else if (row == 9 || row == 10) {
			brick.setColor(Color.CYAN);
		}
	}
	
	private GOval ball;
	
	private void drawBall() {
		double x = (APPLICATION_WIDTH - BALL_RADIUS) / 2;
		double y = (APPLICATION_HEIGHT - BALL_RADIUS) / 2;
		
		ball = new GOval(x, y, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.setColor(Color.BLACK);
		add(ball);
	}
	
	private GRect paddle;
	
	private void drawPaddle() {
		double x = (APPLICATION_WIDTH - PADDLE_WIDTH) / 2;
		double y = HEIGHT - PADDLE_Y_OFFSET;
		
		paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.BLACK);
		add(paddle);
		addMouseListeners(); // allows paddle to listen to mouse movements
	}
	
	public void mouseMoved(MouseEvent e) {
		if (e.getX() > PADDLE_WIDTH / 2 && e.getX() < WIDTH - PADDLE_WIDTH / 2) {
			paddle.setLocation(e.getX() - PADDLE_WIDTH / 2, HEIGHT - PADDLE_Y_OFFSET);
		}
	}
	
	private void playGame() {
		waitForClick();
		getBallVelocity();
	}
	
	// total number of bricks
	private int brickCounter = NBRICKS_PER_ROW * NBRICK_ROWS;
	
	// X and Y velocity of ball
	private double vx, vy;
	
	private void getBallVelocity() {
		vx = rgen.nextDouble(1.0, 3.0);
		vy = 4.0;
//		if (rgen.nextBoolean(0.5)) vx = -vx;
		while (true) {
			moveBall();
			if (ball.getY() >= HEIGHT) break;
			if (brickCounter == 0) break;
		}
	}
	
	private void moveBall() {
		ball.move(vx, vy);
		GObject collider = getCollidingObject();
		
		// when ball collides with side walls
		if (ball.getX() <= 0 || ball.getX() >= WIDTH - 2 * BALL_RADIUS) {
			vx = -vx;
		}
		
		// when ball collides with top wall
		if (ball.getY() <= 0) vy = -vy;
		
		// when ball collides with paddle or bricks
		if (collider == paddle) {
			vy = -vy;
		} else if (collider != null) {
			remove(collider);
			brickCounter--;
			vy = -vy;
		}
		
		pause(DELAY);
	}
	
	private GObject getCollidingObject() {
		// There are 4 cases since the ball has 4 sides.
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY());
		} else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2) != null) {
			return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
		} else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()) != null) {
			return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()); 
		} else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2) != null) {
			return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2); 
		} else {
			return null;
		}
	}
	
	private void printGameOver() {
		GLabel gameOver = new GLabel ("Game Over", WIDTH / 2, HEIGHT / 2);
		gameOver.move(-gameOver.getWidth() / 2, -gameOver.getHeight() / 2);
		gameOver.setColor(Color.RED);
		add(gameOver);
	}
	
	private void printWinner() {
		GLabel winner = new GLabel ("You Won!!!", WIDTH / 2, HEIGHT / 2);
		winner.move(-winner.getWidth() / 2, -winner.getHeight() / 2);
		winner.setColor(Color.RED);
		add(winner);
	} 
}
