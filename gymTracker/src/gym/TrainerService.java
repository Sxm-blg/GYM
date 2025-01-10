package gym;

import java.util.Map;
import java.util.Scanner;

public class TrainerService implements GymUserService {
    private Map<String, GymUser> users;
    private Scanner sc;

    public TrainerService(Map<String, GymUser> users, Scanner sc) {
        this.users = users;
        this.sc = sc;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\nTRAINER-MENÜ:");
            System.out.println("1. Fortschritt aller Mitglieder anzeigen");
            System.out.println("2. Abmelden");

            int choice = sc.nextInt();
            sc.nextLine(); // Puffer leeren

            switch (choice) {
                case 1 -> displayAllProgress();
                case 2 -> {
                    System.out.println("Abgemeldet.");
                    return;
                }
                default -> System.out.println("Ungültige Eingabe.");
            }
        }
    }

    private void displayAllProgress() {
        for (GymUser user : users.values()) {
            if (user instanceof GymMember member) {
            	 System.out.println("\n---------------------------------------");
            	 System.out.println("Mitglied: " + member.getMemberId());
            	 System.out.println("Daten des Mitglieds:");
                 System.out.println("E-Mail: " + member.getEmail());
                 System.out.println("Ziel: " + member.getGoal());
                 System.out.println("Gewicht: " + member.getWeight() + " kg");
                 System.out.println("Größe: " + member.getHeight() + " m");
                 System.out.println("Alter: " + member.getAge() + " Jahre");
                 System.out.println("Zielgewicht: " + member.getTargetWeight() + " kg");
                 System.out.println("Vorheriges Gewicht: " + member.getPreviousWeight() + " kg");
                 System.out.println("Training" + member.getTrainingPlan());
                 
            }
        }
    }
}
