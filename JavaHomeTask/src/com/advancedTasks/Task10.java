package com.advancedTasks;

import java.util.Scanner;

public class Task10 {
	public static void doTask10() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Введите строку:");
			String s = sc.nextLine();
			System.out.println("Введите количество повторов:");
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				System.out.println(i + " : " + s);
			}
			MenuController.exitController();
			sc.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите подходящие значения, пожалуйста.");
			MenuController.exitController();
			sc.close();
		}
	}
}
