package gym;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	private static final String FILE_NAME = "members.txt";
	private static Map<String, GymUser> users = new HashMap<>();
	private static final FitnessCoach trainer = new FitnessCoach("simon.atim@gmail.com", "SerkanBelogi");
	private static Scanner sc = new Scanner(System.in);

	// Registirierungsvariablen wegen Exception
	private static double weight;
	private static double height;
	private static int age;
	private static double targetWeight;

	public static void main(String[] args) {
		users.put(trainer.getEmail(), trainer); // Trainer vorregistrieren
		loadMembersFromFile();

		while (true) {
			System.out.println("\n-------- Hauptmenü --------");
			System.out.println("1. Registrieren");
			System.out.println("2. Anmelden");
			System.out.println("3. Programm beenden");

			int choice = sc.nextInt();
			sc.nextLine(); // Puffer leeren

			switch (choice) {
			case 1 -> registerMember();
			case 2 -> login();
			case 3 -> {
				System.out.println("Programm beendet.");
				return;
			}
			default -> System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
			}
		}
	}

	//method to register a new Member that will be saved in a file
	private static void registerMember() throws InputMismatchException {
		System.out.println("\n-------- REGISTRIERUNG --------");
		System.out.print("E-Mail: ");
		String email = sc.nextLine();

		if (users.containsKey(email)) {
			System.out.println("Diese E-Mail ist bereits registriert.");
			return;
		}

		System.out.print("Passwort: ");
		String password = sc.nextLine();

		System.out.print("Ziel (cut/bulk): ");
		String goal = sc.nextLine();

		System.out.print("Gewicht (kg): ");
		try {
			weight = sc.nextDouble(); // Klassenvariable
		} catch (InputMismatchException e) {
			sc.nextLine(); // Eingabepuffer leeren
			System.out.println("Bitte geben Sie eine gültige Zahl ein!");
			return;
		}

		System.out.print("Größe (m): ");
		try {
			height = sc.nextDouble();
		} catch (InputMismatchException e) {
			sc.nextLine(); // Eingabepuffer leeren
			System.out.println("Bitte geben Sie eine gültige Zahl ein!");
			return;
		}

		System.out.print("Alter: ");
		try {
			age = sc.nextInt();
		} catch (InputMismatchException e) {
			sc.nextLine(); // Eingabepuffer leeren
			System.out.println("Bitte geben Sie eine gültige Zahl ein!");
			return;
		}

		System.out.print("Zielgewicht (kg): ");
		try {
			targetWeight = sc.nextDouble();
		} catch (InputMismatchException e) {
			sc.nextLine(); // Eingabepuffer leeren
			System.out.println("Bitte geben Sie eine gültige Zahl ein!");
			return;
		}

		GymMember member = new GymMember(email, password, goal, weight, height, age, targetWeight);
		users.put(email, member);

		saveMembersToFile();

		System.out.println("\nRegistrierung erfolgreich! Ihre Mitgliedsnummer ist: " + member.getMemberId());
		System.out.println("-------------------------------------------------------------");
	}
	
	
	//method to login with registered email and password, from file or program
	private static void login() {
		System.out.println("\n-------- ANMELDUNG --------");
		System.out.print("E-Mail: ");
		String email = sc.nextLine();
		System.out.print("Passwort: ");
		String password = sc.nextLine();

		GymUser user = users.get(email);
		if (user != null && user.checkPassword(password)) {
			GymUserService service = user.createService(sc, users);
			service.showMenu();
		} else {
			System.out.println("Ungültige E-Mail oder Passwort.");
		}
	}
	
	//method to save the information of a Gym member(without exerciseplan)
	private static void saveMembersToFile() {
		List<String> lines = new ArrayList<>();
		for (GymUser user : users.values()) {
			// Überprüfen, ob der Benutzer ein GymMember ist
			if (user instanceof GymMember) {
				GymMember member = (GymMember) user;
				lines.add(member.toFileFormat());
			}
		}

		try {
			Files.write(Path.of("members.txt"), lines);
			System.out.println("Mitglieder erfolgreich in der Datei gespeichert.");
		} catch (IOException e) {
			System.out.println("Fehler beim Speichern der Mitglieder: " + e.getMessage());
		}
	}
	
	//method to load Members from a text file
	private static void loadMembersFromFile() {

		if (!Files.exists(Path.of(FILE_NAME))) {
			System.out.println("Datei " + FILE_NAME + " existiert nicht. Mitglieder werden nicht geladen.");
			return;
		}

		try {
			List<String> lines = Files.readAllLines(Path.of(FILE_NAME));
			System.out.println("Dateiinhalt wird geladen...");

			for (String line : lines) {
				try {
					String[] parts = line.split(";");
					if (parts.length != 9) {
						System.out.println("Ungültige Zeile: " + line);
						continue; // Überspringe ungültige Zeilen
					}

					GymMember member = GymMember.fromFileFormat(line);
					users.put(member.getEmail(), member);
				} catch (Exception ex) {

					System.out.println("Fehler beim Verarbeiten der Zeile: " + line);
					System.out.println("Fehler: " + ex.getMessage());
				}
			}
			System.out.println("Mitglieder erfolgreich aus der Datei geladen.");
		} catch (IOException e) {

			System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
		}
	}

}
