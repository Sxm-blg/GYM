package gym;

public class Exercise {
    private String name;
    private int sets;
    private int repetitions;
    private int restBetweenSets; // Pause zwischen den Sätzen in Sekunden

    public Exercise(String name, int sets, int repetitions, int restBetweenSets) {
        this.name = name;
        this.sets = sets;
        this.repetitions = repetitions;
        this.restBetweenSets = restBetweenSets;
    }

    public String getName() {
        return name;
    }

    public int getSets() {
        return sets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getRestBetweenSets() {
        return restBetweenSets;
    }

    @Override
    public String toString() {
        return name + " - " + sets + " Sätze, " + repetitions + " Wiederholungen, Pause: " + restBetweenSets + " Sekunden";
    }
}
