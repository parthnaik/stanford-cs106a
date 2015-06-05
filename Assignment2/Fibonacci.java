/**
 * Prints out a fibonacci sequence.
 */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	private static final int MAX_TERM_VALUE = 10000;
	
	public void run() {
		int fibPrev = 0;
		int fibNext = 1;
		int fibCalc = 1;
		
		println("This program lists the Fibonacci sequence");
		println(fibPrev);
		println(fibNext);
		
		while (true) {
			fibCalc = fibPrev + fibNext;
			if (fibCalc > MAX_TERM_VALUE) break;
			println(fibCalc);
			fibPrev = fibNext;
			fibNext = fibCalc;
		}
	}
}
