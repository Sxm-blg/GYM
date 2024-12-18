package gym;

import java.util.ArrayList;
import java.util.List;

public class TrainingPlan {
	 private List<Exercise> exercises = new ArrayList<>();

	    public void addExercise(String name, int sets, int repetitions, int restBetweenSets) {
	        Exercise exercise = new Exercise(name, sets, repetitions, restBetweenSets);
	        exercises.add(exercise);
	    }

	    public void displayPlan() {
	        if (exercises.isEmpty()) {
	            System.out.println("\nKein Trainingsplan vorhanden.");
	            System.out.println("--------------------------------");
	            return;
	        }

	        System.out.println("\n-------- Trainingsplan --------");
	        for (Exercise exercise : exercises) {
	            System.out.println(exercise);
	            System.out.println("----------------------------------------");
	        }
	    }

	    public List<Exercise> getExercises() {
	        return exercises;
	    }

	    public void clearPlan() {
	        exercises.clear();
	        System.out.println("Der Trainingsplan wurde gelöscht.");
	    }

}
