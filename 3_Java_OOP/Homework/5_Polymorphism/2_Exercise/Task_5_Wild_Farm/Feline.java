public abstract class Feline extends Mammal{
    public Feline(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat (Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }
}