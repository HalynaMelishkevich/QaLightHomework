package com.advancedTasks;

public class JavaTask {
	/*
	 * Эталонные обьекты для 5 задания. Final - потому что не изменяются в
	 * программе.Обьявлены здесь, чтобы не создавать эти обьекты каждый раз при
	 * вызове функции 5го задания
	 */
	public static final Object[][] arrMen = new Object[][] { { 20.0, "Недовес" }, { 25.0, "Нормальный вес" },
			{ 30.0, "Избыточный вес" }, { 40.0, "Ожирение" }, { 10000000.0, "Тяжелое ожирение" } };
	public static final Object[][] arrWomen = new Object[][] { { 19.0, "Недовес" }, { 24.0, "Нормальный вес" },
			{ 30.0, "Избыточный вес" }, { 40.0, "Ожирение" }, { 10000000.0, "Тяжелое ожирение" } };

	public static void main(String[] args) {
		MenuController.printMenu();
	}

}