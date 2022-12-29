import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numOfDays = Integer.parseInt(input[1]);
        PriceCalculator.Season season = PriceCalculator.Season.valueOf(input[2]);
        PriceCalculator.Discount discount = PriceCalculator.Discount.valueOf(input[3]);

        double result = PriceCalculator.CalculatePrice(pricePerDay, numOfDays, season, discount);

        System.out.printf("%.2f", result);
    }
}