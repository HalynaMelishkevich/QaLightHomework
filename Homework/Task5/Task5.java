package Task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Дан массив чисел. Выяснить, отсортирован ли он по возрастанию.
**/

public class Task5 {

	public void sortResult(double[] arr) { // check if array is sorted
		int i = 1;
		while (i < arr.length) {
			if (arr[i] > arr[i - 1]) { //compare pairs of elements, going one by one
				i++;
				if(i == arr.length){
					System.out.println("Array is sorted.");
				}
			}else{
				System.out.println("Array is not sorted");
				break;
			};
		}
	}

	public static void main(String[] args) {
		boolean decision = true;
		Scanner sc = new Scanner(System.in);

		while (decision) {
			try {
				System.out.println("How many numbers would you like to input? ");
				int numberCount = sc.nextInt();
				if (numberCount > 0) {
					double[] numberArray = new double[numberCount];
					System.out.println("Input integer numbers:");
					for (int i = 0; i < numberCount; i++) {
						numberArray[i] = sc.nextDouble();
					}
					Task5 obj = new Task5(); //I can call another function only after creating an object
					obj.sortResult(numberArray);
					System.out.println("Want to stop? Say yes: ");
					String decisionInput = sc.next();
					if (decisionInput.toLowerCase().equals("yes") == true) {
						decision = false;
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please, enter a numeric value separated with a dot.");
				// switch to a new line (fixes eternal loop)
				sc.nextLine();
			}
		}
		sc.close();

	}

}
