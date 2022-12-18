import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = reader.readLine().split("\\s+");
        String name = new StringBuilder(input1[0]).append(' ').append(input1[1]).toString();
        Threeuple<String, String, String> first = new Threeuple<>(name, input1[2], input1[3]);

        String[] input2 = reader.readLine().split("\\s+");
        Threeuple<String, Integer, Boolean> second = new Threeuple<>(input2[0], Integer.parseInt(input2[1]), input2[2].equals("drunk"));

        String[] input3 = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> third = new Threeuple<>(input3[0], Double.parseDouble(input3[1]), input3[2]);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}