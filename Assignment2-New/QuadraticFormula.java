/* This program calculate the roots of a given quadratic equation
 * when given the co-efficients.
 */
import acm.program.*;

public class QuadraticFormula extends ConsoleProgram {
	public void run() {
		println("Please enter coefficients of a quadratic equation\n");
		double a = readDouble("Enter a: ");
		double b = readDouble("Enter b: ");
		double c = readDouble("Enter c: ");
		
		double discriminant = calculateDiscriminant(a, b, c);
		
		if (discriminant == 0) {
			double root = (-b + Math.sqrt(discriminant)) / 2 * a;
			println("\nThere is one real root: " + root);
		} else if (discriminant > 0) {
			double firstRoot = (-b + Math.sqrt(discriminant)) / 2 * a;
			double secondRoot = (-b - Math.sqrt(discriminant)) / 2 * a;
			println("\nThere are two roots.");
			println("One root is: " + firstRoot);
			println("The other is: " + secondRoot);
		} else {
			println("\nThere are no real roots.");
		}
	}
	
	private double calculateDiscriminant(double a, double b, double c) {
		return b * b - 4 * a * c;
	}
}