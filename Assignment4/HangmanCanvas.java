/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		drawScaffold();
	}
	
	private void drawScaffold() {
		double scaffoldTopX =  getWidth() / 2 - BEAM_LENGTH;
		double scaffoldTopY = getHeight() / 2 - BODY_LENGTH - HEAD_RADIUS * 2 - ROPE_LENGTH;
		double scaffoldBottomX = scaffoldTopX;
		double scaffoldBottomY = scaffoldTopY + SCAFFOLD_HEIGHT;
		GLine scaffold= new GLine(scaffoldTopX, scaffoldTopY, scaffoldBottomX, scaffoldBottomY);
		add(scaffold);
		double beamRightX = scaffoldTopX + BEAM_LENGTH;
		double beamRightY = scaffoldTopY;
		GLine beam = new GLine(scaffoldTopX, scaffoldTopY, beamRightX, beamRightY);
		add(beam);
		double ropeTopX = getWidth() / 2;
		double ropeTopY = scaffoldTopY;
		double ropeBottomX = ropeTopX;
		double ropeBottomY = ropeTopY + ROPE_LENGTH;
		GLine rope = new GLine(ropeTopX, ropeTopY, ropeBottomX, ropeBottomY);
		add(rope);
	}
	
	private void drawHead() {
		double headX = getWidth() / 2 - HEAD_RADIUS;
		double headY = getHeight() / 2 - BODY_LENGTH - HEAD_RADIUS * 2;
		GOval head = new GOval(headX, headY, HEAD_RADIUS * 2, HEAD_RADIUS * 2);
		add(head);
	}
	
	private void drawBody() {
		double bodyTopX = getWidth() / 2;
		double bodyTopY = getHeight() / 2 - BODY_LENGTH;
		double bodyBottomX = bodyTopX;
		double bodyBottomY = bodyTopY + BODY_LENGTH;
		GLine body = new GLine(bodyTopX, bodyTopY, bodyBottomX, bodyBottomY);
		add(body);
	}
	
	private void drawLeftArm() {
		double armRightX = getWidth() / 2;
		double armRightY = getHeight() / 2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		double armLeftX = armRightX - UPPER_ARM_LENGTH;
		double armLeftY = armRightY;
		double armBottomX = armLeftX;
		double armBottomY = armLeftY + LOWER_ARM_LENGTH;
		GLine leftArm = new GLine(armRightX, armRightY, armLeftX, armLeftY);
		add(leftArm);
		GLine lowerLeftArm = new GLine(armLeftX, armLeftY, armBottomX, armBottomY);
		add(lowerLeftArm);
	}
	
	private void drawRightArm() {
		double armLeftX = getWidth() / 2;
		double armLeftY = getHeight() / 2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		double armRightX = armLeftX + UPPER_ARM_LENGTH;
		double armRightY = armLeftY;
		GLine rightArm = new GLine(armRightX, armRightY, armLeftX, armLeftY);
		add(rightArm);
		double armBottomX = armRightX;
		double armBottomY = armRightY + LOWER_ARM_LENGTH;
		GLine lowerRightArm = new GLine(armRightX, armRightY, armBottomX, armBottomY);
		add(lowerRightArm);
	}
	
	private void drawLeftLeg() {
		double hipRightX = getWidth() / 2;
		double hipRightY = getHeight() / 2;
		double hipLeftX = hipRightX - HIP_WIDTH;
		double hipLeftY = getHeight() / 2;
		GLine leftHip = new GLine(hipRightX, hipRightY, hipLeftX, hipLeftY);
		add(leftHip);
		double legBottomX = hipLeftX;
		double legBottomY = hipLeftY + LEG_LENGTH;
		GLine leftLeg = new GLine(hipLeftX, hipLeftY, legBottomX, legBottomY);
		add(leftLeg);
	}
	
	private void drawRightLeg() {
		double hipLeftX = getWidth() / 2;
		double hipLeftY = getHeight() / 2;
		double hipRightX = hipLeftX + HIP_WIDTH;
		double hipRightY = hipLeftY;
		GLine rightHip = new GLine(hipLeftX, hipLeftY, hipRightX, hipRightY);
		add(rightHip);
		double legBottomX = hipRightX;
		double legBottomY = hipRightY + LEG_LENGTH;
		GLine rightLeg = new GLine(hipRightX, hipRightY, legBottomX, legBottomY);
		add(rightLeg);
	}
	
	private void drawLeftFoot() {
		double footRightX = getWidth() / 2 - HIP_WIDTH;
		double footRightY = getHeight() / 2 + LEG_LENGTH;
		double footLeftX = footRightX - FOOT_LENGTH;
		double footLeftY = footRightY;
		GLine leftFoot = new GLine(footRightX, footRightY, footLeftX, footLeftY);
		add(leftFoot);
	}
	
	private void drawRightFoot() {
		double footLeftX = getWidth() / 2 + HIP_WIDTH;
		double footLeftY = getHeight() / 2 + LEG_LENGTH;
		double footRightX = footLeftX + FOOT_LENGTH;
		double footRightY = footLeftY;
		GLine rightFoot = new GLine(footLeftX, footLeftY, footRightX, footRightY);
		add(rightFoot);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	private double displayWordStoreX = 0;
	private double displayWordStoreY = 0;
	
	public void displayWord(String word) {
		GLabel unGuessedWord = new GLabel(word);
		unGuessedWord.setFont("Halvetica-24");
		if (getElementAt(displayWordStoreX, displayWordStoreY) != null) remove(getElementAt(displayWordStoreX, displayWordStoreY));
		double x = getWidth() / 2 - unGuessedWord.getWidth() / 2;
		double y = getHeight() - HEAD_RADIUS * 2;
		displayWordStoreX = x;
		displayWordStoreY = y;
		unGuessedWord.setLocation(x, y);
		add(unGuessedWord);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	private double noteIncorrectGuessStoreX = 0;
	private double noteIncorrectGuessStoreY = 0;
	
	public void noteIncorrectGuess(String incorrectGuesses) {
		//adds the label with the incorrect letters
		GLabel incorrectLetters = new GLabel(incorrectGuesses);
		if (getElementAt(noteIncorrectGuessStoreX, noteIncorrectGuessStoreY) != null) remove(getElementAt(noteIncorrectGuessStoreX, noteIncorrectGuessStoreY));
		double x = getWidth() / 2 - incorrectLetters.getWidth() / 2;
		double y = getHeight() - HEAD_RADIUS;
		noteIncorrectGuessStoreX = x;
		noteIncorrectGuessStoreY = y;
		incorrectLetters.setLocation(x, y);
		add(incorrectLetters);
		
		//checks how many incorrect guessed letters there are 
		//and draws the next appropriate body part of the hangman
		if (incorrectGuesses.length() == 1) drawHead();
		if (incorrectGuesses.length() == 2) drawBody();
		if (incorrectGuesses.length() == 3) drawLeftArm();
		if (incorrectGuesses.length() == 4) drawRightArm();
		if (incorrectGuesses.length() == 5) drawLeftLeg();
		if (incorrectGuesses.length() == 6) drawRightLeg();
		if (incorrectGuesses.length() == 7) drawLeftFoot();
		if (incorrectGuesses.length() == 8) drawRightFoot();
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
