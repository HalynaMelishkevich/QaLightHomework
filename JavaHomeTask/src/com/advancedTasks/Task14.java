package com.advancedTasks;

public class Task14 {
	public static void doTask14() {
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 1) {
				sum += Task1.factorial(i);
			}
		}
		System.out.println("Сумма факториалов нечетных чисел на отрезке 1-9 равна "+sum);
		MenuController.exitController();
	}
}
