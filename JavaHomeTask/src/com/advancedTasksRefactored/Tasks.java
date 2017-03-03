package com.advancedTasksRefactored;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class Tasks {
	/**
	 * 
	 * @param number
	 * @return
	 */
	public int factorial(int number) {
		int factorial = 1;
		for (int i = 2; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
	/**
	 * 
	 * @param a1
	 * @param a2
	 * @param a3
	 * @return
	 */
	public boolean isTriangle(int a1, int a2, int a3) {
		return (a1 + a2 > a3) && (a1 + a3 > a2) && (a2 + a3 > a1);
	}
	/**
	 * 
	 * @param height
	 */
	public void printTriangle(int height) {
		int k = height;
		int m = 1;
		for (int i = 0; i < height; i++) {
			for (int j = 1; j < k; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < m; j++) {
				System.out.print("0");
			}
			k -= 1;
			m += 2;
			System.out.println();
		}
	}
	/**
	 * 
	 * @param height
	 * @param weight
	 * @return
	 */
	public double calculateIndex(double height, double weight) {
		return weight / Math.pow(height, 2);
	}
	/**
	 * 
	 * @param index
	 * @param sex
	 */
	public void indexMassResult(double index, String sex) {
		if (sex.equals("M") || sex.equals("М")) {
			for (int i = 0; i < TaskStarter.arrMen.length; i++) {
				if (index < (Double) TaskStarter.arrMen[i][0]) {
					System.out.println("Индеск массы тела = " + index + ". Результат - " + TaskStarter.arrMen[i][1]);
					break;
				} else if (index >= (Double) TaskStarter.arrMen[i][0]
						&& index < (Double) TaskStarter.arrMen[i + 1][0]) {
					System.out
							.println("Индеск массы тела = " + index + ". Результат - " + TaskStarter.arrMen[i + 1][1]);
					break;
				}
			}
		} else if (sex.equals("Ж")) {
			for (int i = 0; i < TaskStarter.arrWomen.length; i++) {
				if (index < (Double) TaskStarter.arrWomen[i][0]) {
					System.out.println("Индекс массы тела = " + index + ". Результат - " + TaskStarter.arrWomen[i][1]);
					break;
				} else if (index >= (Double) TaskStarter.arrWomen[i][0]
						&& index < (Double) TaskStarter.arrWomen[i + 1][0]) {
					System.out.println(
							"Индекс массы тела = " + index + ". Результат - " + TaskStarter.arrWomen[i + 1][1]);
					break;
				}
			}
		}
	}
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean isThereEqual(int a) {
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
	/**
	 * 
	 * @param x
	 * @param y
	 * @param h
	 * @return
	 */
	public double calculateV(double x, double y, double h) {
		return Math.abs(x) * Math.abs(y) * Math.abs(h);
	}
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public int countLowGraders(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				counter++;
			}
		}
		return counter;
	}

	// Заполняем банки курсами валют
	public Map<String, Double> returnBanks(Map<String, Double> bank) {
		bank.put("ПриватБанк", 1.0);
		bank.put("РайффайзенБанк", 1.1);
		bank.put("ВТБ", 5.0);
		bank.put("ОщадБанк", 1.3);
		bank.put("VAB", 1.4);
		bank.put("ДніпроБанк", 1.5);
		return bank;
	}

	// Наиболее выгодный банк - в котором курс больше для продажи. Поэтому
	// выбираем наибольший курс и название банка с таким курсом
	public String chooseBank(Map<String, Double> bank) {
		double maxValueInMap = Collections.max(bank.values());
		for (Entry<String, Double> entry : bank.entrySet()) {
			if (entry.getValue() == maxValueInMap) {
				return entry.getKey();
			}
		}
		// если не нашлось такого - возвращаем null
		return null;
	}
	/**
	 * 
	 * @param a1
	 * @param a2
	 * @param a3
	 * @return
	 */
	public double calculateSumMinMax(double a1, double a2, double a3) {
		double min = 0.0, max = 0.0;
		if (a1 < a2 && a1 < a3) {
			min = a1;
		} else if (a2 < a1 && a2 < a3) {
			min = a2;
		} else {
			min = a3;
		}
		if (a1 > a2 && a1 > a3) {
			max = a1;
		} else if (a2 > a1 && a2 > a3) {
			max = a2;
		} else {
			max = a3;
		}
		System.out.println(min);
		System.out.println(max);
		return min + max;
	}
	/**
	 * 
	 * @param a1
	 * @param a2
	 * @param a3
	 * @return
	 */
	public double triangleArea(double a1, double a2, double a3) {
		double p = (a1 + a2 + a3) / 2;
		return Math.sqrt(p * (p - a1) * (p - a2) * (p - a3));
	}
	/**
	 * 
	 * @param a
	 * @return
	 */
	public double hexagonArea(double a) {
		Tasks task2 = new Tasks();
		return (task2.triangleArea(a, a, a)) * 6;
	}
	/**
	 * 
	 * @param price
	 * @return
	 */
	public double calculatePriceWithDiscaunt(double price) {
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
}
