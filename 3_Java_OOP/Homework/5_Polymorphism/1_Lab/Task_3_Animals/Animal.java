package Task_3_Animals;

public class Animal {
    private String name;

    private String favouriteFood;

    protected String explainSelf() {
        return String.format("I am %s and my favourite food is %s", this.name ,this.favouriteFood);
    }

    protected Animal(String name, String favouriteFood) {
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    public String getName() {
        return name;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }
}