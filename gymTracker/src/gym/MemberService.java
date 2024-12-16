package gym;

import java.util.Scanner; 

public class MemberService implements GymUserService {
    private GymMember member;
    private Scanner sc;

    public MemberService(GymMember member, Scanner scanner) {
        this.member = member;
        this.sc = scanner;
    }

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\nMITGLIED-MENÜ:");
            System.out.println("1. Eigene Daten anzeigen");
            System.out.println("2. Daten aktualisieren");
            System.out.println("3. Trainingsplan anzeigen");
            System.out.println("4. Trainingsplan hinzufügen");
            System.out.println("5. Abmelden");

            int choice = sc.nextInt();
            sc.nextLine(); // Puffer leeren

            switch (choice) {
                case 1 -> displayMemberData();
                case 2 -> updateMemberData();
                case 3 -> member.getTrainingPlan().displayPlan();
                case 4 -> addExercise();
                case 5 -> {
                    System.out.println("Abgemeldet.");
                    return;
                }
                default -> System.out.println("Ungültige Eingabe.");
            }
        }
    }

    private void displayMemberData() {
    	System.out.println("Daten des Mitglieds:");
        System.out.println("Mitgliedsnummer: " + member.getMemberId());
        System.out.println("E-Mail: " + member.getEmail());
        System.out.println("Ziel: " + member.getGoal());
        System.out.println("Gewicht: " + member.getWeight() + " kg");
        System.out.println("Größe: " + member.getHeight() + " m");
        System.out.println("Alter: " + member.getAge() + " Jahre");
        System.out.println("Zielgewicht: " + member.getTargetWeight() + " kg");
        System.out.println("Vorheriges Gewicht: " + member.getPreviousWeight() + " kg");
        // Logik, um die Mitgliedsdaten anzuzeigen
    }

    private void updateMemberData() {
    	 System.out.print("Neues Gewicht (kg): ");
         double weight = sc.nextDouble();
         System.out.print("Neue Größe (m): ");
         double height = sc.nextDouble();
         System.out.print("Neues Alter: ");
         int age = sc.nextInt();
         System.out.print("Neues Zielgewicht (kg): ");
         double targetWeight = sc.nextDouble();
         sc.nextLine(); // Puffer leeren

         member.updateData(weight, height, age, targetWeight);
         System.out.println("Daten erfolgreich aktualisiert.");
     }
        // Logik zur Aktualisierung der Daten
    

    private void addExercise() {
    	 System.out.print("Übungsname: ");
    	    String name = sc.nextLine();
    	    System.out.print("Anzahl der Sätze: ");
    	    int sets = sc.nextInt();
    	    System.out.print("Wiederholungen pro Satz: ");
    	    int repetitions = sc.nextInt();
    	    System.out.print("Pause zwischen den Sätzen (Sekunden): ");
    	    int restBetweenSets = sc.nextInt();
    	    sc.nextLine(); // Puffer leeren

    	    member.getTrainingPlan().addExercise(name, sets, repetitions, restBetweenSets);
    	    System.out.println("Übung erfolgreich hinzugefügt.");
        // Weitere Eingaben für die Übung
        // Hinzufügen zur Trainingsplanliste
    }
}
