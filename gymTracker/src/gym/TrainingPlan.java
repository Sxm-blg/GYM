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
	            System.out.println("Kein Trainingsplan vorhanden.");
	            return;
	        }

	        System.out.println("Trainingsplan:");
	        for (Exercise exercise : exercises) {
	            System.out.println(exercise);
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
