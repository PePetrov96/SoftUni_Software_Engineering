package Task_5_Restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert{
    private final double CAKE_GRAMS = 250;

    private final double CAKE_CALORIES = 1000;
    private final BigDecimal CAKE_PRICE = BigDecimal.valueOf(5);

    public Cake(String name) {
        super(name, BigDecimal.valueOf(0), 0, 0);

        super.setGrams(CAKE_GRAMS);
        super.setCalories(CAKE_CALORIES);
        super.setPrice(CAKE_PRICE);
    }

    public double getCAKE_GRAMS() {
        return CAKE_GRAMS;
    }

    public double getCAKE_CALORIES() {
        return CAKE_CALORIES;
    }

    public BigDecimal getCAKE_PRICE() {
        return CAKE_PRICE;
    }
}
