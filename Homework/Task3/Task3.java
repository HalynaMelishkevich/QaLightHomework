package Task3;

import java.util.*;

/*
 * В целочисленном массиве есть нулевые элементы. Создать массив из номеров этих элементов.
 */
public class Task3 {

	public static void main(String[] args) {
		boolean decision = true; //variable for exit criteria
		Scanner sc = new Scanner(System.in); //scanner for reading from a keyboard
		while (decision) {
			try {
				System.out.println("How many numbers would you like to input? ");
				int numberCount = sc.nextInt();
				if (numberCount > 0) {
					int[] numberArray = new int[numberCount];
					/*Before checking, I don't know the array size
					 * So I used ArrayList as it allows to create a dynamic array
					 * P.S.don't know what <> means, but without it my program has warnings
					 * */
					ArrayList<Integer> resultArray = new ArrayList<Integer>();
					System.out.println("Input integer numbers:");
					for (int i = 0; i < numberCount; i++) {
						numberArray[i] = sc.nextInt();
						if(numberArray[i] == 0){ //check zeros during input phase in order not to go looping one more time
							resultArray.add(i);
						}
					}
					System.out.println("Input array : " + Arrays.toString(numberArray) + "\nOutput array : " + resultArray);
					System.out.println("Want to stop? Say yes: ");
					String decisionInput = sc.next();
					if (decisionInput.toLowerCase().equals("yes") == true) {
						decision = false; //exit while loop
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
