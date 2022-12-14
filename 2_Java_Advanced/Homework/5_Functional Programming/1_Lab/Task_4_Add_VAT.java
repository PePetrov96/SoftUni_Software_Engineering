import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Task_4_Add_VAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(",\\s+");
        List<Double> prices = new ArrayList<>();

        for (String s : input)
            prices.add(Double.parseDouble(s));

        UnaryOperator<Double> addVAT = x -> x * 1.2;
        System.out.println("Prices with VAT:");

        for (double price : prices)
            System.out.printf("%1$.2f%n", addVAT.apply(price));
    }
}