import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task_6_Product_Shop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, List<Product>> shops = new TreeMap<>();

        String input;

        while (!"Revision".equals(input = reader.readLine())) {
            String[] tokens = input.split(",\\s+");
            Product product = new Product(tokens[1], Double.parseDouble(tokens[2]));

            if (!shops.containsKey(tokens[0])) {
                shops.put(tokens[0], new ArrayList<>());
            }

            shops.get(tokens[0]).add(product);
        }

        shops.entrySet()
                        .stream()
                                .sorted(Map.Entry.comparingByKey())
                .forEach(key -> {
                    System.out.println(key.getKey() + "->");
                    key.getValue().forEach((k) -> System.out.printf("Product: %s, Price: %.1f%n", k.productName, k.productPrice));
                });

    }
    private static class Product {
        String productName;
        double productPrice;
        public Product(String productName, double productPrice) {
            this.productName = productName;
            this.productPrice = productPrice;
        }
    }
}