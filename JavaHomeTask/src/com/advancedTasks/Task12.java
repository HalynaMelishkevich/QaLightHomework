package com.advancedTasks;

import java.util.Scanner;

public class Task12 {
	public static double triangleArea(double a1, double a2, double a3) {
		double p = (a1 + a2 + a3) / 2;
		return Math.sqrt(p * (p - a1) * (p - a2) * (p - a3));
	}

	public static void doTask12() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите длину первой стороны:");
			Double x1 = sc.nextDouble();
			System.out.println("Введите длину второй стороны:");
			Double x2 = sc.nextDouble();
			System.out.println("Введите длину третьей стороны:");
			Double x3 = sc.nextDouble();
			System.out.println("Площадь треугольника равна " + triangleArea(x1, x2, x3));
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
