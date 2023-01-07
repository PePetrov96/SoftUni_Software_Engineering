package Task_3_Animals;

public class Cat extends Animal{
    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }
    @Override
    public String explainSelf() {
        return String.format("%s%nMEEOW", super.explainSelf());
    }
}