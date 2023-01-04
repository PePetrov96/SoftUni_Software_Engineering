package Task_2_Car_Shop_Extended;

public class CarImpl implements Car {
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String countryProduces;

    protected CarImpl(String model, String color, Integer horsePower, String countryProduces) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduces = countryProduces;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduces;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires"
                ,getModel()
                ,countryProduced()
                ,this.TIRES);
    }

}