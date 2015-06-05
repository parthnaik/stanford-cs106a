/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {
	private ArrayList <String> wordList = new ArrayList <String> ();	

	public HangmanLexicon() {
	//adds the individual words in the file to the array list
		try {
			BufferedReader hangmanWords = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true) {
				String line = hangmanWords.readLine();
				if(line == null) break;
				wordList.add(line);
			}
			hangmanWords.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}


	/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordList.get(index);
	}

	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return wordList.size();
	}	
}

//public class HangmanLexicon extends ConsoleProgram {
//	public void run() {
//		setUpGame();
//		playGame();
//	}
//	
//	// instance variables
//	public static final int GUESS_COUNTER = 8;
//	private HangmanLexicon lexicon;
//	private RandomGenerator rgen = new RandomGenerator();
//	private int guessesRemaining = GUESS_COUNTER;
//	String hiddenWord;
//	String currentWord;
//	
//	private void setUpGame() {
//		hiddenWord = getHiddenWord();
//	}
//	
//	private String getHiddenWord() {
//		lexicon = new HangmanLexicon();
//		int wordCount = lexicon.getWordCount();
//		int randomWordIndex = rgen.nextInt(0, wordCount - 1);
//		return lexicon.getWord(randomWordIndex);
//	}
//	
//	private String guessedLetters = "";
//	
//	private void playGame() {
//		println("Welcome to Hangman!");
//		
//		while (guessesRemaining > 0) {						
//			println("The word now looks like this: " + checkGuess());
//			
//			// check if current word is equal to guessed word
//			if (hiddenWord.equals(currentWord)) {
//				println("You guessed the word: " + currentWord);
//				println("You win");
//				break;
//			}
//			
//			println("You have " + guessesRemaining + " guesses left.");
//			
//			String guess = readLine("Your guess: ");
//			
//			// guess validation
//			while (guess.length() > 1) {
//				guess = readLine("You can only guess one character at a time. Try again: ");
//			}
//			
//			guess = guess.toUpperCase();
//			
//			guessedLetters += guess;
//			if (!hiddenWord.contains(guess)) guessesRemaining--;
//			
//			// game lost if no guesses remaining
//			if (guessesRemaining == 0) {
//				println("There are no " + guess + "\'s in the word.");
//				println("You are completely hung.");
//				println("The word was " + hiddenWord);
//				println("You lose.");
//			}
//		}
//	}
//	
//	private String checkGuess() {
//		currentWord = "";
//		
//		for (int i = 0, n = hiddenWord.length(); i < n; i++) {
//			char currentLetter = hiddenWord.charAt(i);
//			
//			if (!containsLetter(guessedLetters, currentLetter)) {
//				currentWord += "-";
//			} else {
//				currentWord += currentLetter;
//			}
//		}
//		
//		return currentWord;
//	}
//	
//	// checks if guessed string so far contains letter
//	private boolean containsLetter(String word, char letter) {
//		if (word.indexOf(letter) == -1) {
//			return false;
//		} else {
//			return true;
//		}
//	}
//
///** Returns the number of words in the lexicon. */
//	public int getWordCount() {
//		return 10;
//	}
//
///** Returns the word at the specified index. */
//	public String getWord(int index) {
//		switch (index) {
//			case 0: return "BUOY";
//			case 1: return "COMPUTER";
//			case 2: return "CONNOISSEUR";
//			case 3: return "DEHYDRATE";
//			case 4: return "FUZZY";
//			case 5: return "HUBBUB";
//			case 6: return "KEYHOLE";
//			case 7: return "QUAGMIRE";
//			case 8: return "SLITHER";
//			case 9: return "ZIRCON";
//			default: throw new ErrorException("getWord: Illegal index");
//		}
//	};
//}
