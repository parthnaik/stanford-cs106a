import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram {
	public void run() {
		int lines = 0;
		int words = 0;
		int chars = 0;
		
		BufferedReader rd = openFileReader("File: ");
		
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lines++;
				words += countWords(line);
				chars += line.length();
			}
			rd.close();
		} catch (IOException ex) {
			println("An I/O exception has occurred"); 
		}
		
		println("Lines = " + lines);
		println("Words = " + words);
		println("Chars = " + chars);
	}
	
	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd = null;
		
		while (rd == null) {
			String name = readLine(prompt);
			try {
				rd = new BufferedReader(new FileReader(name)); 
			} catch (IOException ex) {
				println("Can't open that file."); 
			}
		}
		
		return rd;
	}
	
	private int countWords(String line) {
		boolean inWord = false;
		int words = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord) words++;
				inWord = false;
			}
		}
		if (inWord) words++;
		return words;
	}
}


