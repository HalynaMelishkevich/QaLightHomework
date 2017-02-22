package com.advancedTasks;

import java.util.Scanner;

public class Task5 {
	public static double calculateIndex(double height, double weight) {
		return weight / Math.pow(height, 2);
	}

	public static void indexMassResult(double index, String sex) {
		if (sex.equals("M") || sex.equals("М")) {
			for (int i = 0; i < JavaTask.arrMen.length; i++) {
				if (index < (Double) JavaTask.arrMen[i][0]) {
					System.out.println("Индеск массы тела = " + index + ". Результат - " + JavaTask.arrMen[i][1]);
					break;
				} else if (index >= (Double) JavaTask.arrMen[i][0] && index < (Double) JavaTask.arrMen[i + 1][0]) {
					System.out.println("Индеск массы тела = " + index + ". Результат - " + JavaTask.arrMen[i + 1][1]);
					break;
				}
			}
		} else if (sex.equals("Ж")) {
			for (int i = 0; i < JavaTask.arrWomen.length; i++) {
				if (index < (Double) JavaTask.arrWomen[i][0]) {
					System.out.println("Индекс массы тела = " + index + ". Результат - " + JavaTask.arrWomen[i][1]);
					break;
				} else if (index >= (Double) JavaTask.arrWomen[i][0] && index < (Double) JavaTask.arrWomen[i + 1][0]) {
					System.out.println("Индекс массы тела = " + index + ". Результат - " + JavaTask.arrWomen[i + 1][1]);
					break;
				}
			}
		}
	}

	public static void doTask5() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Введите пол (М или Ж): ");
			String sex = sc.nextLine().toUpperCase();
			System.out.println("Введите рост (м): ");
			double height = sc.nextDouble();
			System.out.println("Введите вес (кг): ");
			double weight = sc.nextDouble();
			if ((sex.equals("M") || sex.equals("М") || sex.equals("Ж")) && height > 0 && weight > 0) {
				indexMassResult(calculateIndex(height, weight), sex);
			} else {
				System.out.println("Вводите валидные значения, пожалуйста.");
			}
			MenuController.exitController();
			sc.close();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			MenuController.exitController();
			sc.close();
		}
	}
}
