package com.advancedTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
	public static boolean isThereEqual(int a) {
		String str = Integer.toString(a);
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == chars[i]) {
				return true;
			}
		}
		return false;
	}

	public static void doTask6() {
		System.out.println("Введите целое число:");
		try (Scanner sc = new Scanner(System.in)){
			int compareNumber = Math.abs(sc.nextInt());
			if (isThereEqual(compareNumber)) {
				System.out.println("Это число имеет одинаковые цифры.");
			} else {
				System.out.println("Это число не имеет одинаковых цифр.");
			}
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
