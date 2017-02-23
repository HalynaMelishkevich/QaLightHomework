package com.advancedTasks;

import java.util.Scanner;

public class Task13 {
	public static double hexagonArea(double a) {
		return (Task12.triangleArea(a, a, a)) * 6;
	}

	public static void doTask13() {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Введите длину стороны шестиугольника:");
			Double x1 = sc.nextDouble();
			System.out.println("Площадь шестиугольника равна " + hexagonArea(x1));
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
