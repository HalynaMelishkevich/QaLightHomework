package com.advancedTasksRefactored;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TaskController {
	Menu menu = new Menu();
	Tasks task = new Tasks();
	public void doTask1() {
		System.out.println("Введите число, факториал которого Вы хотите вычислить:");
		try (Scanner sc = new Scanner(System.in)) { // магия Java 8 - сканнер
													// сам закроется
			int factorialNumber = sc.nextInt();
			if (factorialNumber < 1) {
				System.out.println("Число должно быть больше 0.");
				doTask1();
			} else if (factorialNumber == 1 || factorialNumber == 2) {
				System.out.println("Факториал числа " + factorialNumber + " = " + factorialNumber);
			} else {
				System.out.println("Факториал числа " + factorialNumber + " = " + task.factorial(factorialNumber));
			}
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask2() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите абсциссу первой точки: ");
			double x1 = sc.nextDouble();
			System.out.print("Введите ординату первой точки: ");
			double y1 = sc.nextDouble();
			System.out.print("Введите абсциссу второй точки: ");
			double x2 = sc.nextDouble();
			System.out.print("Введите ординату второй точки: ");
			double y2 = sc.nextDouble();
			System.out.println("Расстояние между двумя точками = " + task.getDistance(x1, y1, x2, y2));
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask3() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите длину первой стороны треугольника: ");
			int a1 = sc.nextInt();
			System.out.print("Введите длину второй стороны треугольника: ");
			int a2 = sc.nextInt();
			System.out.print("Введите длину третьей стороны треугольника: ");
			int a3 = sc.nextInt();
			if (task.isTriangle(a1, a2, a3) == true) {
				System.out.println("Треугольник с такими сторонами возможен.");
				menu.exitController();
			} else {
				System.out.println("Треугольник с такими сторонами не возможен.");
				menu.exitController();
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask4() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите высоту треугольника: ");
			int height = sc.nextInt();
			if (height < 1) {
				System.out.println("Введите число больше 0.");
			} else {
				task.printTriangle(height);
			}
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask5() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Введите пол (М или Ж): ");
			String sex = sc.nextLine().toUpperCase();
			System.out.println("Введите рост (м): ");
			double height = sc.nextDouble();
			System.out.println("Введите вес (кг): ");
			double weight = sc.nextDouble();
			if ((sex.equals("M") || sex.equals("М") || sex.equals("Ж")) && height > 0 && weight > 0) {
				task.indexMassResult(task.calculateIndex(height, weight), sex);
			} else {
				System.out.println("Вводите валидные значения, пожалуйста.");
			}
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask6() {
		System.out.println("Введите целое число:");
		try (Scanner sc = new Scanner(System.in)){
			int compareNumber = Math.abs(sc.nextInt());
			if (task.isThereEqual(compareNumber)) {
				System.out.println("Это число имеет одинаковые цифры.");
			} else {
				System.out.println("Это число не имеет одинаковых цифр.");
			}
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только целые числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask7() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите длину бассейна:");
			double lenght = sc.nextDouble();
			System.out.println("Введите ширину бассейна:");
			double width = sc.nextDouble();
			System.out.println("Введите высоту бассейна:");
			double height = sc.nextDouble();
			System.out.println("Обьем воды для заполнения бассейна(м^3):");
			// без форматирования большое число будет в научном виде (1.0Е9)
			System.out.format("%50.2f%n", task.calculateV(width, lenght, height));
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask8() {
		Random rand = new Random();
		//Генерируем рандомное число оценок (всего человек в группе)
		int randSize = rand.nextInt((50 - 4) + 1) + 4;
		int[] studentsMarksArray = new int[randSize];
		//заполняем массив оценок
		for (int i = 0; i < randSize; i++) {
			studentsMarksArray[i] = rand.nextInt((5 - 2) + 1) + 2;
		}
		System.out.println("Массив оценок: " + Arrays.toString(studentsMarksArray));
		System.out.println("Количество двоечников: " + task.countLowGraders(studentsMarksArray));
		menu.exitController();
	}
	public void doTask9() {
		Map<String, Double> banks = new HashMap<String, Double>();
		task.returnBanks(banks);
		if (task.chooseBank(banks) == null) {
			System.out.println("К сожалению, подходящего банка не нашлось.");
		} else {
			System.out.println("Наилучший для обмена банк - " + task.chooseBank(banks));
		}
		menu.exitController();
	}
	public void doTask10() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите строку:");
			String s = sc.nextLine();
			System.out.println("Введите количество повторов:");
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				System.out.println(i + " : " + s);
			}
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите подходящие значения, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask11() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите первое число:");
			Double x1 = sc.nextDouble();
			System.out.println("Введите второе число:");
			Double x2 = sc.nextDouble();
			System.out.println("Введите третье число:");
			Double x3 = sc.nextDouble();
			System.out.println("Сумма большего и меньшего значений равна " + task.calculateSumMinMax(x1, x2, x3));
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask12() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите длину первой стороны:");
			Double x1 = sc.nextDouble();
			System.out.println("Введите длину второй стороны:");
			Double x2 = sc.nextDouble();
			System.out.println("Введите длину третьей стороны:");
			Double x3 = sc.nextDouble();
			System.out.println("Площадь треугольника равна " + task.triangleArea(x1, x2, x3));
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask13() {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Введите длину стороны шестиугольника:");
			Double x1 = sc.nextDouble();
			System.out.println("Площадь шестиугольника равна " + task.hexagonArea(x1));
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
	public void doTask14() {
		int sum = 0;
		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 1) {
				sum += task.factorial(i);
			}
		}
		System.out.println("Сумма факториалов нечетных чисел на отрезке 1-9 равна "+sum);
		menu.exitController();
	}
	public void doTask15() {
		TaskController contr = new TaskController();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Введите цену: ");
			double price = sc.nextDouble();
			if (price >= 0) {
				System.out.println("Стоимость с учетом скидки равна " + task.calculatePriceWithDiscaunt(price));
			} else {
				System.out.println("Цена не может быть ниже ноля.");
				contr.doTask15();
			}
			menu.exitController();
		} catch (java.util.InputMismatchException e) {
			System.out.println("Вводите только числа, пожалуйста.");
			menu.exitController();
		}
	}
}
