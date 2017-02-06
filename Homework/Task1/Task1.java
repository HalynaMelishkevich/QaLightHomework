package Task1;

import java.util.Scanner;

/*
 * Дано два числа. Найти минимальное число из них.
 */

public class Task1 {

	public static void main(String[] args) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter two numbers:");
				double n1 = sc.nextDouble();
				double n2 = sc.nextDouble();
				System.out.println("Minimum = " + Math.min(n1, n2)); //calling Math.min function turned out to be better than just comparing two double values
			} catch (java.util.InputMismatchException e) { //without catching exceptions, program will be stopped on input non-numeric values or non-integer, separated with not a dot
				System.out.println("Please, enter a numeric value separated with a dot.");
			}
		}
	}

}
