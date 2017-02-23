package com.advancedTasks;

import java.util.Scanner;

public class Task7 {
	public static double calculateV(double x, double y, double h) {
		return Math.abs(x) * Math.abs(y) * Math.abs(h);
	}

	public static void doTask7() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите длину бассейна:");
			double lenght = sc.nextDouble();
			System.out.println("Введите ширину бассейна:");
			double width = sc.nextDouble();
			System.out.println("Введите высоту бассейна:");
			double height = sc.nextDouble();
			System.out.println("Обьем воды для заполнения бассейна(м^3):");
			// без форматирования большое число будет в научном виде (1.0Е9)
			System.out.format("%50.2f%n", calculateV(width, lenght, height));
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
