package christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy{
    private static final double Initial_Gingerbread_Portion = 200;
    public Gingerbread(String name, double price) {
        super(name, Initial_Gingerbread_Portion, price);
    }
}