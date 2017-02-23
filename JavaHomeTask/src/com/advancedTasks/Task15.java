package com.advancedTasks;

import java.util.Scanner;

public class Task15 {
	public static double calculatePriceWithDiscaunt(double price) {
		if (price <= 1000.0) {
			return price;
		} else if (price > 1000 && price <= 2000) {
			return price - price * 0.02;
		} else if (price > 2000 && price <= 5000) {
			return price - price * 0.05;
		} else {
			return price - price * 0.07;
		}
	}

	public static void doTask15() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите цену: ");
			double price = sc.nextDouble();
			if (price >= 0) {
				System.out.println("Стоимость с учетом скидки равна " + calculatePriceWithDiscaunt(price));
			} else {
				System.out.println("Цена не может быть ниже ноля.");
				Task15.doTask15();
			}
			MenuController.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
		}
	}
}
