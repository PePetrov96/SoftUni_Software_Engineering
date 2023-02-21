import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Bag bag = new Bag(Long.parseLong(reader.readLine()));

        String[] input = reader.readLine().split("\\s+");

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long weight = Long.parseLong(input[i + 1]);

            if (item.length() == 3) {
                bag.addCash(item, weight);
            } else if (item.toLowerCase().endsWith("gem") && item.length() > 3) {
                bag.addGems(item,weight);
            }else if(item.equalsIgnoreCase("gold")){
                bag.addGold(weight);
            }
        }

        System.out.println(bag);
    }
}