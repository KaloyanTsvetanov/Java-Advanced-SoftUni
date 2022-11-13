package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(a -> a.getName().equals(name) && a.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().filter(a -> a.getName().equals(name) && a.getMuscle().equals(muscle)).findAny().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparingInt(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount(){
        return exercises.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(type).append("\n");
        for (Exercise exercise : exercises) {
            sb.append(exercise).append("\n");
        }
        return sb.toString();
    }
}
