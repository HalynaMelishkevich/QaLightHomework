package com.advancedTasks;

import java.util.Scanner;

public class MenuController {
	public static void printMenu() {
		System.out.println("Выберите задание:" + "\n1.Вычисление факториала."
				+ "\n2.Расстояние между точками в двумерной плоскости." + "\n3.Проверка треугольника."
				+ "\n4.Треугольник из нулей." + "\n5.Индекс массы тела."
				+ "\n6.Проверка на повторяющиеся цифры в трехзначном числе." + "\n7.Вычисление литража басейна."
				+ "\n8.Подсчет количества двоечников." + "\n9.Вычисление выгодного банка для обмена валют."
				+ "\n10.Вывести на экран строку N раз." + "\n11.Сумма максимума и минимума из трех чисел."
				+ "\n12.Вычисление площади треугольника." + "\n13.Вычисление площади шестиугольника."
				+ "\n14.Вычисление суммы факториалов всех нечетных чисел от 1 до 9."
				+ "\n15.Стоимость покупки со скидкой.");
		decisionController();
	}

	public static void decisionController() {
		Scanner sc = new Scanner(System.in);
		int decision = sc.nextInt();
		switch (decision) {
		case 1:
			Task1.doTask1();
			break;
		default:
			System.out.println("Всего хорошего!");
			break;
		}
		sc.close();
	}
}
