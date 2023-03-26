package christmasPastryShop.entities.booths;

public class PrivateBooth extends BaseBooth{
    private static final double Initial_Price_Per_Person = 3.50;
    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, Initial_Price_Per_Person);
    }
}