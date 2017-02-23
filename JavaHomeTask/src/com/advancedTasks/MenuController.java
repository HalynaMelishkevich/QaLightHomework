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
		try {
			int decision = sc.nextInt();
			switch (decision) {
			case 1:
				Task1.doTask1();
				break;
			case 2:
				Task2.doTask2();
				break;
			case 3:
				Task3.doTask3();
				break;
			case 4:
				Task4.doTask4();
				break;
			case 5:
				Task5.doTask5();
				break;
			case 6:
				Task6.doTask6();
				break;
			case 7:
				Task7.doTask7();
				break;
			case 8:
				Task8.doTask8();
				break;
			case 9:
				Task9.doTask9();
				break;
			case 10:
				Task10.doTask10();
				break;
			case 11:
				Task11.doTask11();
				break;
			case 12:
				Task12.doTask12();
				break;
			case 13:
				Task13.doTask13();
				break;
			case 14:
				Task14.doTask14();
				break;
			case 15:
				Task15.doTask15();
				break;
			default:
				exitController();
				break;
			}
			sc.close();
		} catch (java.util.InputMismatchException e) {
			exitController();
			sc.close();
		}
	}

	public static void exitController() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Для выхода из программы введите 1 : ");
			if (sc.nextInt() == 1) {
				System.exit(0);
			} else {
				printMenu();
			}
			sc.close();
		} catch (java.util.InputMismatchException e) {
			printMenu();
			sc.close();
		}
	}
}
