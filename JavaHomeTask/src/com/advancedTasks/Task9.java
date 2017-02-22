package com.advancedTasks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Task9 {
	// Заполняем банки курсами валют
	public static Map<String, Double> returnBanks(Map<String, Double> bank) {
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
	public static String chooseBank(Map<String, Double> bank) {
		double maxValueInMap = Collections.max(bank.values());
		for (Entry<String, Double> entry : bank.entrySet()) {
			if (entry.getValue() == maxValueInMap) {
				return entry.getKey();
			}
		}
		// если не нашлось такого - возвращаем null
		return null;
	}

	public static void doTask9() {
		Map<String, Double> banks = new HashMap<String, Double>();
		returnBanks(banks);
		if (chooseBank(banks) == null) {
			System.out.println("К сожалению, подходящего банка не нашлось.");
		} else {
			System.out.println("Наилучший для обмена банк - " + chooseBank(banks));
		}
		MenuController.exitController();
	}
}
