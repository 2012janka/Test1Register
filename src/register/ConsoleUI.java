package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	public ConsoleUI(Register register) {
		this.register = register;
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				return;
			}
		}
	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	private void printRegister() {
		for (int i = 0; i < register.getCount(); i++) {
			System.out.println((i + 1) + ". "
					+ register.getPerson(i).toString());
		}
	}

	private void addToRegister() {
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();

		if (register.findPersonByName(name) != null)
			System.out.println("V zozname uz existuje osoba s rovnakym menom!");
		else if (register.findPersonByPhoneNumber(phoneNumber) != null) {
			System.out
					.println("V zozname uz existuje osoba s rovnakym telefonnym cislom!");
		} else {
			register.addPerson(new Person(name, phoneNumber));
		}
	}

	private void updateRegister() {
		boolean novyVyber = new Boolean(true);
		while (novyVyber) {
			System.out
					.println("Pre zmenu mena stlacte m, pre zmenu telefonneho cisla stlacte c.");
			String vyber = readLine();
			if (vyber.equals("m")) {
				System.out.println("Zadajte stare meno: ");
				String name = readLine();
				if (register.findPersonByName(name) == null) {
					System.out
							.println("Osoba so zadanym menom sa nenachadza v zozname. Opakujte vyber.");
				} else {
					System.out.println("Zadajte nove meno: ");
					String newName = readLine();
					if (register.findPersonByName(name) != null) {
						System.out
								.println("V zozname uz existuje osoba s rovnakym menom!");
					} else {
						register.findPersonByName(name).setName(newName);
						novyVyber = false;
					}
				}
			} else if (vyber.equals("c")) {
				System.out.println("Zadajte meno: ");
				String name = readLine();
				if (register.findPersonByName(name) == null) {
					System.out
							.println("Osoba so zadanym menom sa nenachadza v zozname. Opakujte vyber.");
				} else {
					System.out.println("Zadajte nove telefonne cislo: ");
					String phoneNumber = readLine();
					if (register.findPersonByPhoneNumber(phoneNumber) != null) {
						System.out
								.println("V zozname uz existuje osoba s rovnakym telefonnym cislom!");
					} else {
						register.findPersonByName(name).setPhoneNumber(
								phoneNumber);
						novyVyber = false;
					}
				}
			} else {
				System.out.println("Zly vstup!");
			}
		}
	}

	private void findInRegister() {
		boolean novyVyber = new Boolean(true);
		while (novyVyber) {
			System.out
					.println("Pre vyhladavanie podla mena stlacte m, pre vyhladavanie podla telefonneho cisla stlacte c.");
			String vyber = readLine();
			if (vyber.equals("m")) {
				System.out.println("Zadajte meno: ");
				String name = readLine();
				if (register.findPersonByName(name) == null) {
					System.out
							.println("Osoba so zadanym menom sa v zozname nenachadza.");
					novyVyber = false;
				} else {
					System.out.println(register.getIndex(register
							.findPersonByName(name))
							+ ". "
							+ register.findPersonByName(name).toString());
					novyVyber = false;
				}
			} else if (vyber.equals("c")) {
				System.out.println("Zadajte telefonne cislo: ");
				String cislo = readLine();
				if (register.findPersonByPhoneNumber(cislo) == null) {
					System.out
							.println("Osoba so zadanym telefonnym cislom sa v zozname nenachadza.");
					novyVyber = false;
				} else {
					System.out.println(register.getIndex(register
							.findPersonByPhoneNumber(cislo))
							+ ". "
							+ register.findPersonByPhoneNumber(cislo)
									.toString());
					novyVyber = false;
				}
			} else {
				System.out.println("Zly vstup!");
			}
		}
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}

}
