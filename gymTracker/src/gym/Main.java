package gym;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	    private static Map<String, GymUser> users = new HashMap<>();
	    private static final FitnessCoach trainer = new FitnessCoach("simon.atim@gmail.com", "SerkanBelogi");
	    private static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        users.put(trainer.getEmail(), trainer); // Trainer vorregistrieren

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

	    private static void registerMember() {
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
	        double weight = sc.nextDouble();

	        System.out.print("Größe (m): ");
	        double height = sc.nextDouble();

	        System.out.print("Alter: ");
	        int age = sc.nextInt();

	        System.out.print("Zielgewicht (kg): ");
	        double targetWeight = sc.nextDouble();

	        GymMember member = new GymMember(email, password, goal, weight, height, age, targetWeight);
	        users.put(email, member);

	        System.out.println("\nRegistrierung erfolgreich! Ihre Mitgliedsnummer ist: " + member.getMemberId());
	        System.out.println("-------------------------------------------------------------");
	    }

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
	     //   System.out.println("Mitglied erstellt: " + member);
	       // System.out.println("Mitgliedsnummer: " + member.getMemberId());

	    }
	    
	}

