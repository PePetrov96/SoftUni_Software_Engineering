package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int KILOGRAMS = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(getKilograms() + 1);
    }
}