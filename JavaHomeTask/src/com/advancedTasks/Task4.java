package com.advancedTasks;

import java.util.Scanner;

public class Task4 {
	public static void printTriangle(int height) {
		int k = height;
		int m = 1;
		for (int i = 0; i < height; i++) {
			for (int j = 1; j < k; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < m; j++) {
				System.out.print("0");
			}
			k -= 1;
			m += 2;
			System.out.println();
		}
	}

	public static void doTask4() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите высоту треугольника: ");
			int height = sc.nextInt();
			if (height < 1) {
				System.out.println("Введите число больше 0.");
			} else {
				printTriangle(height);
			}
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
