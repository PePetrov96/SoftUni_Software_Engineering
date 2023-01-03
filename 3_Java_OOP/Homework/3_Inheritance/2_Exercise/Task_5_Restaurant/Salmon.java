package Task_5_Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    private final double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price) {
        super(name, price, 0);
        super.setGrams(SALMON_GRAMS);
    }

    public double getSALMON_GRAMS() {
        return SALMON_GRAMS;
    }
}