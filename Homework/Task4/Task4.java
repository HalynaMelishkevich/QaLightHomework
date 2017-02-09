package Task4;

import java.util.Scanner;

/*
 * Дан целочисленный массив чисел (положительных и отрицательных). 
 * Выяснить, какое число встречается раньше – положительное или отрицательное.
 * */
public class Task4 {

	public static void main(String[] args) {
		boolean decision = true; //variable for exit criteria
		Scanner sc = new Scanner(System.in); //scanner for reading from a keyboard
		while (decision) {
			try {
				System.out.println("How many numbers would you like to input? ");
				int numberCount = sc.nextInt(); //the array size
				if (numberCount > 0) {
					int[] numberArray = new int[numberCount];
					System.out.println("Input integer numbers:");
					for (int i = 0; i < numberCount; i++) { //input numbers one by one
						numberArray[i] = sc.nextInt();
						if(numberArray[i] < 0){ //if the first inputed number is below 0 - then its negative
							System.out.println("The first is negative.");
							break;
						}else if(numberArray[i] > 0){ //if the first inputed number is above 0 - then its positive
							System.out.println("The first is positive.");
							break;
						}// if its zero - increment and check the next value
					}
					System.out.println("Want to stop? Say yes: "); //if user wants to stop a program, he can do it with typing 'yes'
					String decisionInput = sc.next();
					if (decisionInput.toLowerCase().equals("yes") == true) {
						decision = false; //exit from while loop
					}
				}
			} catch (java.util.InputMismatchException e) { //catches non-numeric values and too long ones
				System.out.println("Please, enter a numeric value separated with a dot.");
				//switch to a new line (fixes eternal loop)
				sc.nextLine();
			}
		}
		sc.close();
	}
}
