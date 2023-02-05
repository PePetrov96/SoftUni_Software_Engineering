import java.util.*;

public class Task_6_List_of_Products {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            products.add(scan.nextLine());
        }
        sortAndPrint(products);
    }
    private static void sortAndPrint (List<String> products) {
        Collections.sort(products);
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n",(i + 1), products.get(i));
        }
    }
}