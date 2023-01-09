import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task_3_Enter_Numbers {
    static List<Integer> numbers = new ArrayList<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        while (numbers.size() < 10) {
            try {
                readNumber(numbers.get(numbers.size()-1), 100);
            } catch (IndexOutOfBoundsException ex) {
                readNumber(1, 100);
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\]]",""));

    }
    private static void readNumber(int start, int end) throws IOException {
        String line = reader.readLine();

        try {
            int num = Integer.parseInt(line);

            if (num > start && num < end) {
                numbers.add(num);
            } else {
                throw new IllegalArgumentException(String.format("Your number is not in range %d - 100!", start));
            }
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Number!");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}