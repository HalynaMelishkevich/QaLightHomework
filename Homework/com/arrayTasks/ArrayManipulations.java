package com.arrayTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulations {

	public static void main(String[] args) {
		boolean decision = true;
		Scanner sc = new Scanner(System.in);

		while (decision) {
			try {
				System.out.println("How many numbers would you like to input? ");
				int numberCount = sc.nextInt();
				if (numberCount > 0) {
					double[] numberArray = new double[numberCount];
					System.out.println("Input array numbers:");
					for (int i = 0; i < numberCount; i++) {
						numberArray[i] = sc.nextDouble();
					}

					System.out.println("Input number for comparing in task 7 :");
					double compareNumber = sc.nextDouble();
					replaceBiggerNumbersThanZ(numberArray.clone(), compareNumber); // Task7
					
					returnEvenArray(numberArray.clone()); // Task6
					
					elementsQuantity(numberArray.clone()); // Task8
					
					changeMinMax(numberArray.clone()); // Task9
					
					printValueBiggerThanIndex(numberArray.clone()); // Task10
					
					System.out.println("Input remainder for task 11: ");
					int remainder = sc.nextInt();
					System.out.println("Input number for comparing in task 11: ");
					int compare = sc.nextInt();
					printCertainRemainder(numberArray.clone(), remainder, compare); // Task11
					
					switchNeighbourElements(numberArray.clone()); // Task12
					
					printBeforeZero(numberArray.clone()); // Task13
					
					sumMinMax(numberArray.clone()); // Task14
					
					System.out.println("Input number for comparing in task 15: ");
					int m = sc.nextInt();
					returnBiggerThanM(numberArray.clone(), m); // Task15
					
					returnZerosIfModuleBigger(numberArray.clone()); // Task16
					
					calculateBiggerOfMultiplies(numberArray.clone());// Task17
					
					replaceFirstMax(numberArray.clone()); // Task18
					
					System.out.println("Input number for adding in the end of every number in task 19: ");
					int k = sc.nextInt();
					returnArrayK(numberArray.clone(), k); // Task19

					System.out.println("Want to stop? Say yes: ");
					String decisionInput = sc.next();
					if (decisionInput.toLowerCase().equals("yes") == true) {
						decision = false;
					}
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please, enter a numeric value separated with a dot.");
				// switch to a new line (fixes eternal loop)
				sc.nextLine();
			}
		}
		sc.close();
	}

	/*
	 * 6 Дан массив чисел. Создать массив из четных чисел этого массива. Если
	 * таких чисел нет, то вывести сообщение об этом факте.
	 */
	public static void returnEvenArray(double[] arr) {
		ArrayList<Double> returnArray = new ArrayList<Double>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				returnArray.add(arr[i]);
			}
		}
		if (returnArray.isEmpty()) {
			System.out.println("Task6: Array does not contain any even numbers.\n");
		} else {
			System.out.println("Task6: Array of even numbers -> " + returnArray + "\n");
		}
	}

	/*
	 * 7 Дан массив чисел. Заменить все его элементы, большие данного числа Z,
	 * этим числом. Подсчитать количество замен.
	 */
	public static void replaceBiggerNumbersThanZ(double[] arr, double z) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > z) {
				arr[i] = z;
				counter++;
			}
		}
		System.out.println("Task7: New array -> " + Arrays.toString(arr) + "\nNumber of switches -> " + counter + "\n");
	}

	/*
	 * 8 Дан массив чисел. Подсчитать, сколько в нем отрицательных,
	 * положительных и нулевых элементов.
	 */
	public static void elementsQuantity(double[] arr) {
		int quantityNegative = 0;
		int quantityPositive = 0;
		int quantityZeros = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				quantityNegative++;
			} else if (arr[i] == 0) {
				quantityZeros++;
			} else {
				quantityPositive++;
			}
		}
		System.out.println("Task8: " + quantityNegative + " negative elements, " + quantityPositive
				+ " positive elements, " + quantityZeros + " zero elements.\n");
	}

	/*
	 * 9 Дан массив чисел. Поменять местами наибольший и наименьший элементы.
	 */
	public static void changeMinMax(double[] arr) {
		int indexMin = 0, indexMax = 0;
		double temp = 0.0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[indexMin]) {
				indexMin = i;
			} else if (arr[i] > arr[indexMax]) {
				indexMax = i;
			}
		}
		temp = arr[indexMin];
		arr[indexMin] = arr[indexMax];
		arr[indexMax] = temp;
		System.out.println("Task9: " + Arrays.toString(arr) + "\n");
	}

	/*
	 * 10 Дан массив. Вывести на печать только те числа, для которых выполняется
	 * условие arr[i] ≤ i.
	 */
	public static void printValueBiggerThanIndex(double[] arr) {
		System.out.print("Task10: values that are less than their indexes -> [");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= i) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.print("]\n");
	}

	/*
	 * 11 Дан массив чисел. Вывести те числа, у которых остаток от деления на
	 * число М равен L.
	 */
	public static void printCertainRemainder(double[] arr, int rem, int com) {
		System.out.print("Task11: numbers that has remainder " + rem + " compared with " + com + " -> ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % com == rem) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println("\n");
	}

	/*
	 * 12 Дан массив чисел. Поменять местами соседние элементы (а[0] и а[1],
	 * а[2] и а[3], …)
	 */
	public static void switchNeighbourElements(double[] arr) {
		for (int i = 1; i < arr.length; i += 2) {
			double temp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = temp;
		}
		System.out.println("Task12: Switched array: " + Arrays.toString(arr) + "\n");
	}

	/*
	 * 13 Дан массив чисел, среди которых имеется один нуль. Вывести на печать
	 * все числа, включительно до нуля.
	 */
	public static void printBeforeZero(double[] arr) {
		System.out.print("Task13: Elements before zero -> [");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				System.out.print(arr[i] + " ");
			} else {
				break;
			}
		}
		System.out.println("]\n");
	}

	/*
	 * 14 Дан массив чисел. Найти  mаx(а[0], а[2], ..., а[2к]) + min(а[1], а[3],
	 * …, а[2к-1]).
	 */
	public static void sumMinMax(double[] arr) {
		double min = arr[0], max = arr[1];
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 1) {
				if (arr[i] > max) {
					max = arr[i];
				}
			} else {
				if (arr[i] < min) {
					min = arr[i];
				}
			}
		}
		System.out.println("Task14: max of even numbers + min of odd numbers is " + (min + max) + "\n");
	}

	/*
	 * 15 Дан массив целых положительных чисел. Найти произведение только тех
	 * чисел, которые больше заданного числа М. Если таких нет, то выдать
	 * сообщение об этом.
	 */
	public static void returnBiggerThanM(double[] arr, double m) {
		double resultMultiplication = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > m) {
				resultMultiplication *= arr[i];
			}
		}
		if (resultMultiplication == 1) {
			System.out.println("Task15: Array does not contain elements bigger than " + m + ".\n");
		} else {
			System.out.println("Task15: " + resultMultiplication);
		}
	}

	/*
	 * 16 Дан массив положительных и отрицательных чисел.  Заменить нулями те
	 * числа, величина которых по модулю больше максимального числа (|a[i]| >
	 * max{ a[0], a[1], ..., a[n]})
	 */
	public static void returnZerosIfModuleBigger(double[] arr) {
		double max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i]) > max) {
				arr[i] = 0;
			}
		}
		System.out.println("Task16: " + Arrays.toString(arr));
	}

	/*
	 * 17 Дан массив чисел с положительными и отрицательными элементы. Вычислить
	 * произведение отрицательных элементов P1 и произведение положительных
	 * элементов Р2. Сравнить модуль Р2 с модулем Р1 и указать, какое из
	 * произведений по модулю больше.
	 */
	public static void calculateBiggerOfMultiplies(double[] arr) {
		double negativeMult = 1.0, positiveMult = 1.0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negativeMult *= arr[i];
			} else if (arr[i] > 0) {
				positiveMult *= arr[i];
			}
		}
		if (Math.abs(negativeMult) > Math.abs(positiveMult)) {
			System.out.println("Task17: negative numbers multiplication result is bigger and equal to " + negativeMult);
		} else if (Math.abs(negativeMult) < Math.abs(positiveMult)) {
			System.out.println("Task17: positive numbers multiplication result is bigger and equal to " + positiveMult);
		} else {
			System.out.println("Task17: multiplication results are equal.");
		}
	}

	/*
	 * 18 Дан массив чисел. Среди них есть равные. Найти первый максимальный
	 * элемент массива и заменить его нулем.
	 */
	public static void replaceFirstMax(double[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		arr[max] = 0;
		System.out.println("Task18: " + Arrays.toString(arr));
	}

	/*
	 * 19 Дан массив чисел. Образовать новый массив, элементами которого будут
	 * элементы исходного, оканчивающиеся на цифру k.
	 */
	public static void returnArrayK(double[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 10 + k;
		}
		System.out.println("Task19: " + Arrays.toString(arr));
	}
}
