import java.util.Random;
import java.util.Scanner;

public class Task_1_Randomize_Words {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Random rnd = new Random();
        for (int post1 = 0; post1 < input.length; post1++) {
            int post2 = rnd.nextInt(input.length);
            String temp = input[post1];
            input[post1] = input[post2];
            input[post2] = temp;
        }
        System.out.println(String.join(System.lineSeparator(), input));
    }
}