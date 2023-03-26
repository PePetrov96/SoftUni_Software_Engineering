package christmasPastryShop.entities.cocktails;

public class Hibernation extends BaseCocktail{
    private static final double Initial_hibernation_Price = 4.50;
    public Hibernation(String name, int size, String brand) {
        super(name, size, Initial_hibernation_Price, brand);
    }
}