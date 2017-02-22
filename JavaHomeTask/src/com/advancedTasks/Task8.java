package com.advancedTasks;

import java.util.Arrays;
import java.util.Random;

public class Task8 {
	public static int countLowGraders(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 2) {
				counter++;
			}
		}
		return counter;
	}

	public static void doTask8() {
		Random rand = new Random();
		//Генерируем рандомное число оценок (всего человек в группе)
		int randSize = rand.nextInt((50 - 4) + 1) + 4;
		int[] studentsMarksArray = new int[randSize];
		//заполняем массив оценок
		for (int i = 0; i < randSize; i++) {
			studentsMarksArray[i] = rand.nextInt((5 - 2) + 1) + 2;
		}
		System.out.println("Массив оценок: " + Arrays.toString(studentsMarksArray));
		System.out.println("Количество двоечников: " + countLowGraders(studentsMarksArray));
		MenuController.exitController();
	}
}
