package ru.computers;

import java.util.Scanner;

public class Executable {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		System.out.println("Введите количество компьютеров:");
		int compCount = scanner.nextInt();
		scanner.close();
		if (compCount == 0) {
			System.out.println("Компьютеры отсутствуют");
			return;
		}
		Computer[] allComputers = new Computer[compCount + 1];
		Computer.compArrayHandle = allComputers;
		for (int i = 0; i < compCount; i++) {
			allComputers[i] = new Computer("Comp_" + i, false);
		}
		allComputers[compCount] = new Computer("Admin", true);

		// 1. Пробуем перезапустить все машины с машины юзера
		Computer userMachine = Computer.getCompById("Comp_4");
		userMachine.batchCommand("reboot");
		// 2. Включаем машины с админского компа
		Computer adminMachine = Computer.getCompById("Admin");
		adminMachine.batchCommand("on");
		// 3. Перезагружаем с админского компа
		adminMachine.batchCommand("reboot");
		// 4. Нескольким рандомным компам задаем статус
		
		

	}
}
