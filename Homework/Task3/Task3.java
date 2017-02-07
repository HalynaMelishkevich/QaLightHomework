package Task3;

import java.util.Scanner;

/*
 * В целочисленном массиве есть нулевые элементы. Создать массив из номеров этих элементов.
 */
public class Task3 {

	public static void main(String[] args) {
		boolean decision = true;
		Scanner sc = new Scanner(System.in);
		while (decision) {
			try {
				
				
			} catch (java.util.InputMismatchException e) { //without catching exceptions, program will be stopped on input non-numeric values or non-integer, separated with not a dot
				System.out.println("Please, enter a numeric value separated with a dot.");
			}
		}
		sc.close();

	}

}
