package Task_3_Wild_Farm;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    protected String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %s, %s]",
                this.getAnimalType(),
                this.getAnimalName(),
                this.getBreed(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}