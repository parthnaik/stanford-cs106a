import acm.program.*;
import acm.util.*;

public class AddCommas extends ConsoleProgram {
	public void run() {
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}
	
	private static final int DELIMITER_SIZE = 3;
	
	private String addCommasToNumericString(String digits) {
		String formattedDigits = "";
		int counter = 0;
		
		for (int i = digits.length() - 1; i >= 0; i--) {
			formattedDigits = digits.charAt(i) + formattedDigits;
			counter++;
			if (counter > 0 && counter % 3 == 0 && counter != digits.length()) formattedDigits = "," + formattedDigits;
		}
		
		return formattedDigits;
	}
}


