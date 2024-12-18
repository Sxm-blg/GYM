package gym;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	
	    private static Map<String, GymUser> users = new HashMap<>();
	    private static final FitnessCoach trainer = new FitnessCoach("simon.atim@gmail.com", "SerkanBelogi");
	    private static Scanner sc = new Scanner(System.in);
		
	    //Registirierungsvariablen wegen Exception
	    private static double weight;
	    private static double height;
	    private static int age;
	    private static double targetWeight;
	    
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

	    private static void registerMember() throws InputMismatchException{
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
	        double weight = sc.nextDouble();
	        } catch(InputMismatchException e) {
	        	throw new InputMismatchException("Bitte geben Sie eine Zahl ein!");
	        }
	      

	        System.out.print("Größe (m): ");
	        try { double height = sc.nextDouble();
	        } catch(InputMismatchException e) {
	        	throw new InputMismatchException("Bitte geben Sie eine Zahl ein!");
	        }

	        System.out.print("Alter: ");
	        try { int age = sc.nextInt();
	        } catch(InputMismatchException e) {
	        	throw new InputMismatchException("Bitte geben Sie eine Zahl ein!");
	        }

	        System.out.print("Zielgewicht (kg): ");
	        try { double targetWeight = sc.nextDouble();
	        } catch(InputMismatchException e) {
	        	throw new InputMismatchException("Bitte geben Sie eine Zahl ein!");
	        }

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

