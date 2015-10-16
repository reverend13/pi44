package ru.computers;

public class Computer {
	private String Name;
	private Boolean IsMain;
	private Boolean Status;

	public static Object compArrayHandle;

	public Computer(String name, Boolean isMain) {
		Name = name;
		IsMain = isMain;
		Status = false;
	}

	public void on() {
		if (Status) {
			System.out.printf("Компьютер %s уже включен\n", Name);
			return;
		}
		Status = true;
		System.out.printf("Компьютер %s включен\n", Name);
	}

	public void off() {
		if (!Status) {
			System.out.printf("Компьютер %s уже выключен\n", Name);
			return;
		}
		Status = false;
		System.out.printf("Компьютер %s выключен\n", Name);
	}

	public void reboot() {
		if (!Status) {
			System.out.printf("Компьютер %s выключен, перезагрузка невозможна\n", Name);
			return;
		}
		System.out.printf("Компьютер %s перезагружен\n", Name);
	}

	public static Computer getCompById(String name) {
		Computer[] compArray = (Computer[]) compArrayHandle;
		if (compArray == null) {
			System.out.println("Не удалось прочитать массив компьютеров\n");
		}
		for (Computer computer : compArray) {
			if (computer.Name.equals(name)) {
				System.out.printf("Управление передано компьютеру %s\n", name);
				return computer;
			}
		}
		System.out.printf("Компьютер %s не найден\n", name);
		return null;
	}

	public void batchCommand(String command) {
		if (!IsMain) {
			System.out.printf("Компьютер %s не является главным\n", Name);
			return;
		}
		Computer[] compArray = (Computer[]) compArrayHandle;
		if (compArray == null) {
			System.out.println("Не удалось прочитать массив компьютеров\n");
		}
		for (Computer computer : compArray) {
			computer.acceptCommand(command);
		}
	}

	public void acceptCommand(String command) {
		String com = command.toLowerCase();
		switch (com) {
		case "on":
			on();
			break;
		case "off":
			off();
		case "reboot":
			reboot();
		}
	}
}
