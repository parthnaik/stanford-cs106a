/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	private HangmanCanvas canvas;
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}

    public void run() {
		/* You fill this in */
    	setUpGame();
		playGame();
	}
    
    public static final int GUESS_COUNTER = 8;
	private HangmanLexicon lexicon;
	private RandomGenerator rgen = new RandomGenerator();
	private int guessesRemaining = GUESS_COUNTER;
	String hiddenWord;
	String currentWord;
	
	private void setUpGame() {
		canvas.reset();
		hiddenWord = getHiddenWord();
	}
	
	private String getHiddenWord() {
		lexicon = new HangmanLexicon();
		int wordCount = lexicon.getWordCount();
		int randomWordIndex = rgen.nextInt(0, wordCount - 1);
		return lexicon.getWord(randomWordIndex);
	}
	
	private String guessedLetters = "";
	private String incorrectGuesses = "";
	
	private void playGame() {
		println("Welcome to Hangman!");
		
		while (guessesRemaining > 0) {						
			println("The word now looks like this: " + checkGuess());
			
			// check if current word is equal to guessed word
			if (hiddenWord.equals(currentWord)) {
				println("You guessed the word: " + currentWord);
				println("You win");
				break;
			}
			
			println("You have " + guessesRemaining + " guesses left.");
			
			String guess = readLine("Your guess: ");
			
			// guess validation
			while (guess.length() > 1) {
				guess = readLine("You can only guess one character at a time. Try again: ");
			}
			
			guess = guess.toUpperCase();
			
			guessedLetters += guess;
			if (!hiddenWord.contains(guess)) incorrectGuesses += guess;
			
			if (!hiddenWord.contains(guess)) {
				guessesRemaining--;
			}
			
			canvas.noteIncorrectGuess(incorrectGuesses);
			
			// game lost if no guesses remaining
			if (guessesRemaining == 0) {
				println("There are no " + guess + "\'s in the word.");
				println("You are completely hung.");
				println("The word was " + hiddenWord);
				println("You lose.");
			}
		}
	}
	
	private String checkGuess() {
		currentWord = "";
		
		for (int i = 0, n = hiddenWord.length(); i < n; i++) {
			char currentLetter = hiddenWord.charAt(i);
			
			if (!containsLetter(guessedLetters, currentLetter)) {
				currentWord += "-";
			} else {
				currentWord += currentLetter;
			}
		}
		
		canvas.displayWord(currentWord);
		return currentWord;
	}
	
	// checks if guessed string so far contains letter
	private boolean containsLetter(String word, char letter) {
		if (word.indexOf(letter) == -1) {
			return false;
		} else {
			return true;
		}
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	};
}
