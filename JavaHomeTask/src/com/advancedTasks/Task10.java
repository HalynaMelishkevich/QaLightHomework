package com.advancedTasks;

import java.util.Scanner;

public class Task10 {
	public static void doTask10() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите строку:");
			String s = sc.nextLine();
			System.out.println("Введите количество повторов:");
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				System.out.println(i + " : " + s);
			}
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите подходящие значения, пожалуйста.");
			MenuController.exitController();
		}
	}
}
