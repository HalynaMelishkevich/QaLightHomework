package Task2;

import java.util.Scanner;

/*
 * Дан целочисленный массив чисел. Найти сумму элементов, кратных данному числу K
 */

public class Task2 {
	public int sumCalculating(int[] mas, int k) { //calculates the sum of array elements that are K fold
		int sum = 0;
		for (int j = 0; j < mas.length; j++) {
			if (mas[j] % k == 0) { //check multiplicity with K
				sum += mas[j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean decision = true; //variable for exit criteria
		Scanner sc = new Scanner(System.in); //scanner for keyboard reading
		while (decision) {
			try {
				System.out.println("How many numbers would you like to input?");
				int numberCount = sc.nextInt(); //the array size
				if (numberCount > 0) {
					int[] numberArray = new int[numberCount];
					System.out.println("Input integer numbers:");
					for (int i = 0; i < numberCount; i++) {
						numberArray[i] = sc.nextInt(); //filling in the array
					}
					System.out.println("Type the number your massive should be compared to:");
					int multiplicity = sc.nextInt();
					if (multiplicity != 0) {
						Task2 obj = new Task2(); //sumCalculating function can be applied only for a class'es object, so I created an object for that
						System.out.println("The sum is " + obj.sumCalculating(numberArray, multiplicity)
								+ "\nWonna stop?Say yes:");
						String decisionInput = sc.next();
						if (decisionInput.toLowerCase().equals("yes") == true) {
							decision = false;
						}
					} else { //fixing division by zero problem
						System.out.println("You can't compare multiplicity to zero. Try with another number.");
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please, enter a numeric value separated with a dot.");
				//switch to a new line (fixes eternal loop)
				sc.nextLine();
			}
		}
		sc.close();
	}

}
