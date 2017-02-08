package Task3;

import java.util.*;

/*
 * В целочисленном массиве есть нулевые элементы. Создать массив из номеров этих элементов.
 */
public class Task3 {

	public static void main(String[] args) {
		boolean decision = true;
		Scanner sc = new Scanner(System.in);
		while (decision) {
			try {
				System.out.println("How many numbers would you like to input? ");
				int numberCount = sc.nextInt();
				if (numberCount > 0) {
					int[] numberArray = new int[numberCount];
					ArrayList<Integer> resultArray = new ArrayList<Integer>();
					System.out.println("Input integer numbers:");
					for (int i = 0; i < numberCount; i++) {
						numberArray[i] = sc.nextInt();
						if(numberArray[i] == 0){
							resultArray.add(i);
						}
					}
					System.out.println("Input array : " + Arrays.toString(numberArray) + "\nOutput array : " + resultArray);
					System.out.println("Want to stop? Say yes: ");
					String decisionInput = sc.next();
					if (decisionInput.toLowerCase().equals("yes") == true) {
						decision = false;
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please, enter a numeric value separated with a dot.");
				sc.nextLine();
			}
		}
		sc.close();

	}

}
