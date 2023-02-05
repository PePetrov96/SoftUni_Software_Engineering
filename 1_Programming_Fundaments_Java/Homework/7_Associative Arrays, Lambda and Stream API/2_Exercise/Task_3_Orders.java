import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task_3_Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Product> productList = new LinkedHashMap<>();

        String[] input = scan.nextLine().split("\\s+");

        while (!input[0].equals("buy")) {
            collectProduct(productList, input);
            input = scan.nextLine().split("\\s+");
        }

        productList.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, (value.quantity * value.price)));
    }
    private static void collectProduct (LinkedHashMap<String, Product> productList, String[] input) {
        Product product = new Product();
        product.price = Double.parseDouble(input[1]);

        if (!productList.containsKey(input[0])) {
            product.quantity = Integer.parseInt(input[2]);
        } else {
            product.quantity = productList.get(input[0]).quantity + Integer.parseInt(input[2]);
        }

        productList.put(input[0], product);
    }
    public static class Product {
        double price;
        int quantity;
    }
}