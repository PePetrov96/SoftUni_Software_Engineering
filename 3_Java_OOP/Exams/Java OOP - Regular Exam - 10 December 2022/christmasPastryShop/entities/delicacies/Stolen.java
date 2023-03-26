package christmasPastryShop.entities.delicacies;

public class Stolen extends BaseDelicacy{
    private static final double Initial_Stolen_Portion = 250;
    public Stolen(String name, double price) {
        super(name, Initial_Stolen_Portion, price);
    }
}