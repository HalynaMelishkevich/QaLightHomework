package com.advancedTasks;

import java.util.Scanner;

public class Task3 {
	public static boolean isTriangle(int a1, int a2, int a3) {
		return (a1 + a2 > a3) && (a1 + a3 > a2) && (a2 + a3 > a1);
	}

	public static void doTask3() {
		Scanner sc = new Scanner(System.in);
		try {
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
			sc.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			MenuController.exitController();
			sc.close();
		}
	}
}
