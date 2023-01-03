package Task_5_Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{
    private final double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, BigDecimal.valueOf(0), 0);

        double COFFEE_MILLILITERS = 50;
        super.setMilliliters(COFFEE_MILLILITERS);

        BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
        super.setPrice(COFFEE_PRICE);

        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}