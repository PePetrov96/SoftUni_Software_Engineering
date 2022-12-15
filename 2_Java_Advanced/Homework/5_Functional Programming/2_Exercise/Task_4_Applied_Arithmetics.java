import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task_4_Applied_Arithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command;

        while (!"end".equals(command = reader.readLine())) {
            switch (command){
                case "print":
                    System.out.println(Arrays.toString(input).replaceAll("[\\[\\],]",""));
                    break;
                case "add":
                    input = Arrays.stream(input).map(a -> a + 1).toArray();
                    break;
                case "multiply" :
                    input = Arrays.stream(input).map(a -> a * 2).toArray();
                    break;
                case "subtract" :
                    input = Arrays.stream(input).map(a -> a - 1).toArray();
                    break;
            }
        }
    }
}