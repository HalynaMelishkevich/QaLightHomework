package com.advancedTasks;

import java.util.Scanner;

public class Task3 {
	public static boolean isTriangle(int a1, int a2, int a3) {
		return (a1 + a2 > a3) && (a1 + a3 > a2) && (a2 + a3 > a1);
	}

	public static void doTask3() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите длину первой стороны треугольника: ");
			int a1 = sc.nextInt();
			System.out.print("Введите длину второй стороны треугольника: ");
			int a2 = sc.nextInt();
			System.out.print("Введите длину третьей стороны треугольника: ");
			int a3 = sc.nextInt();
			if (isTriangle(a1, a2, a3) == true) {
				System.out.println("Треугольник с такими сторонами возможен.");
				MenuController.exitController();
			} else {
				System.out.println("Треугольник с такими сторонами не возможен.");
				MenuController.exitController();
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
