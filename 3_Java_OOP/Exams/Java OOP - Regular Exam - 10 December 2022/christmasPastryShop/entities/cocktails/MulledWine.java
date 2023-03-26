package christmasPastryShop.entities.cocktails;

public class MulledWine extends BaseCocktail{
    private static final double Initial_mulledWine_Price = 3.50;
    public MulledWine(String name, int size, String brand) {
        super(name, size, Initial_mulledWine_Price, brand);
    }
}