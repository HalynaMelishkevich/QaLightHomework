package Task1;

import java.util.Scanner;

/*
 * Дано два числа. Найти минимальное число из них.
 */

public class Task1 {

	public static void main(String[] args) {
		boolean decision = true;
		Scanner sc = new Scanner(System.in);
		while (decision) {
			try {
				System.out.println("Enter two numbers:");
				double n1 = sc.nextDouble();
				double n2 = sc.nextDouble();
				System.out.println("Minimum = " + Math.min(n1, n2)+"\nWonna stop?Say yes:"); //calling Math.min function turned out to be better than just comparing two double values
				String decisionInput = sc.next();				
				if(decisionInput.toLowerCase().equals("yes") == true){
					decision = false;
				}
			} catch (java.util.InputMismatchException e) { //without catching exceptions, program will be stopped on input non-numeric values or non-integer, separated with not a dot
				System.out.println("Please, enter a numeric value separated with a dot.");
				/*nextDouble function reads line-by-line
				 * and if exception was caught
				 * nextDouble would not switch to a new line
				 * so I have to do it manually, because without it there is an ETERNAL LOOP OMG!!!
				 * */
				sc.nextLine();
			}
		}
		sc.close();
	}

}
