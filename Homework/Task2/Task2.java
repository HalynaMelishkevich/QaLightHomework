package Task2;

import java.util.Scanner;

/*
 * Дан целочисленный массив чисел. Найти сумму элементов, кратных данному числу K
 */

public class Task2 {
	public int sumCalculating(int[] mas, int k) {
		int sum = 0;
		for (int j = 0; j < mas.length; j++) {
			if (mas[j] % k == 0) {
				sum += mas[j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("How many numbers would you like to input?");
				int numberCount = sc.nextInt();
				int[] numberMassive = new int[numberCount];
				System.out.println("Input integer numbers:");
				for (int i = 0; i < numberCount; i++) {
					numberMassive[i] = sc.nextInt();
				}
				System.out.println("Type the number your massive should be compared to:");
				int multiplicity = sc.nextInt();
				Task2 obj = new Task2();
				System.out.println("The sum is " + obj.sumCalculating(numberMassive, multiplicity));
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please, enter a numeric value separated with a dot.");
			}
		}

	}

}
