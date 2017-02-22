package com.advancedTasks;

import java.util.Scanner;

public class Task1 {
	public static int factorial(int number) {
		int factorial = 1;
		for (int i = 2; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void doTask1() {
		System.out.println("Введите число, факториал которого Вы хотите вычислить:");
		Scanner sc = new Scanner(System.in);
		try {
			int factorialNumber = sc.nextInt();
			if (factorialNumber < 1) {
				System.out.println("Число должно быть больше 0.");
				doTask1();
			} else if (factorialNumber == 1 || factorialNumber == 2) {
				System.out.println("Факториал числа " + factorialNumber + " = " + factorialNumber);
			} else {
				System.out.println("Факториал числа " + factorialNumber + " = " + factorial(factorialNumber));
			}
			MenuController.exitController();	
			sc.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			MenuController.exitController();
			sc.close();
		}
	}
}
