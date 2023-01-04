package Task_2_Car_Shop_Extended;

public class Seat extends CarImpl implements Sellable {
    private final Double price;

    protected Seat(String model, String color, Integer horsePower, String countryProduces, Double price) {
        super(model, color, horsePower, countryProduces);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "\nLeon sells for %f", getPrice());
    }
}