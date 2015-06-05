import acm.program.*;
import acm.util.*;

public class RemoveOccurences extends ConsoleProgram {
	public void run() {
		while (true) {
			String input = readLine("Enter string: ");
			String toRemove = readLine("Enter character to remove: ");
			char ch = toRemove.charAt(0);
			println(removeAllOccurences(input, ch));
		}
	}
	
	private String removeAllOccurences(String input, char ch) {
		String result = "";
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ch) {
				result = result + input.charAt(i);
			}
		}
		
		return result;
	}
}
