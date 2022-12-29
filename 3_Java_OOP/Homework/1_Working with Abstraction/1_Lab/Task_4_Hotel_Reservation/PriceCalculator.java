public class PriceCalculator {
    public enum Season {
        Spring(2), Summer(4), Autumn(1), Winter(3);
        private final int value;
        Season(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
    public enum Discount {
        None(0), SecondVisit(10), VIP(20);

        private final int value;
        Discount(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static double CalculatePrice (double pricePerDay, int numOfDays, Season season, Discount discount) {
        int multiplier = season.getValue();
        double priceBeforeDiscount = numOfDays * pricePerDay * multiplier;
        double discountPercent = discount.getValue() / 100.0;
        double discountedAmount = priceBeforeDiscount * discountPercent;
        return priceBeforeDiscount - discountedAmount;
    }
}