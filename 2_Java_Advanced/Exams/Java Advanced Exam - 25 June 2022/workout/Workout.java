package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private int exerciseCount;
    private String type;

    public void addExercise(Exercise exercise) {
        if (getExerciseCount() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle)  {
        for (int i = 0; i < this.exercises.size(); i++) {
            if (this.exercises.get(i).getName().equals(name) &&
                    this.exercises.get(i).getMuscle().equals(muscle)) {

                this.exercises.remove(i);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                .filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream()
                .max(Comparator.comparingInt(Exercise::getBurnedCalories))
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder("Workout type: ").append(this.type).append(System.lineSeparator());

        this.exercises.forEach(exercise -> result
                .append(exercise.toString())
                .append(System.lineSeparator()));

        return result.toString();
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public Workout(String type, int exerciseCount) {
        this.setExercises();
        this.setExerciseCount(exerciseCount);
        this.setType(type);
    }

    public List<Exercise> getExercises() {
        return Collections.unmodifiableList(exercises);
    }

    public String getType() {
        return type;
    }

    private void setExercises() {
        this.exercises = new ArrayList<>();
    }

    private void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    private void setType(String type) {
        this.type = type;
    }
}
