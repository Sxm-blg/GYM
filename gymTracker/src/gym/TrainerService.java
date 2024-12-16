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
                // Logik zur Anzeige des Fortschritts
            }
        }
    }
}
