package com.advancedTasksRefactored;

import java.util.Scanner;

public class Menu {
	public void printMenu() {
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

	public void decisionController() {
		TaskController controller = new TaskController();		
		try(Scanner sc = new Scanner(System.in)) {
			int decision = sc.nextInt();
			switch (decision) {
			case 1:
				controller.doTask1();
				break;
			case 2:
				controller.doTask2();
				break;
			case 3:
				controller.doTask3();
				break;
			case 4:
				controller.doTask4();
				break;
			case 5:
				controller.doTask5();
				break;
			case 6:
				controller.doTask6();
				break;
			case 7:
				controller.doTask7();
				break;
			case 8:
				controller.doTask8();
				break;
			case 9:
				controller.doTask9();
				break;
			case 10:
				controller.doTask10();
				break;
			case 11:
				controller.doTask11();
				break;
			case 12:
				controller.doTask12();
				break;
			case 13:
				controller.doTask13();
				break;
			case 14:
				controller.doTask14();
				break;
			case 15:
				controller.doTask15();
				break;
			default:
				exitController();
				break;
			}
		} catch (java.util.InputMismatchException e) {
			exitController();
		}
	}

	public void exitController() {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Для выхода из программы введите 1 : ");
			if (sc.nextInt() == 1) {
				System.exit(0);
			} else {
				printMenu();
			}
		} catch (java.util.InputMismatchException e) {
			printMenu();
		}
	}
}
