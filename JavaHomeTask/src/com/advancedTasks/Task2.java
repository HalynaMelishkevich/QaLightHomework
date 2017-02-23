package com.advancedTasks;

import java.util.Scanner;

public class Task2 {
	public static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

	public static void doTask2() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите абсциссу первой точки: ");
			double x1 = sc.nextDouble();
			System.out.print("Введите ординату первой точки: ");
			double y1 = sc.nextDouble();
			System.out.print("Введите абсциссу второй точки: ");
			double x2 = sc.nextDouble();
			System.out.print("Введите ординату второй точки: ");
			double y2 = sc.nextDouble();
			System.out.println("Расстояние между двумя точками = " + getDistance(x1, y1, x2, y2));
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
