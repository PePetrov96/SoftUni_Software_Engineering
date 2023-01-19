package workout;

public class Exercise {
    private String name;
    private String	muscle;
    private int burnedCalories;

    public Exercise(String name, String muscle, int burnedCalories) {
        this.setName(name);
        this.setMuscle(muscle);
        this.setBurnedCalories(burnedCalories);
    }

    @Override
    public String toString() {
        return String.format("Exercise: %s, %s, %d", this.name, this.muscle, this.burnedCalories);
    }


    public String getName() {
        return name;
    }

    public String getMuscle() {
        return muscle;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    private void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }
}
