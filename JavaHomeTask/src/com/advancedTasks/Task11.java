package com.advancedTasks;

import java.util.Scanner;

public class Task11 {
	public static double calculateSumMinMax(double a1, double a2, double a3) {
		double min = 0.0, max = 0.0;
		if (a1 < a2 && a1 < a3) {
			min = a1;
		} else if (a2 < a1 && a2 < a3) {
			min = a2;
		} else {
			min = a3;
		}
		if (a1 > a2 && a1 > a3) {
			max = a1;
		} else if (a2 > a1 && a2 > a3) {
			max = a2;
		} else {
			max = a3;
		}
		System.out.println(min);
		System.out.println(max);
		return min + max;
	}

	public static void doTask11() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Введите первое число:");
			Double x1 = sc.nextDouble();
			System.out.println("Введите второе число:");
			Double x2 = sc.nextDouble();
			System.out.println("Введите третье число:");
			Double x3 = sc.nextDouble();
			System.out.println("Сумма большего и меньшего значений равна " + calculateSumMinMax(x1, x2, x3));
			MenuController.exitController();
			sc.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
			sc.close();
		}
	}
}
