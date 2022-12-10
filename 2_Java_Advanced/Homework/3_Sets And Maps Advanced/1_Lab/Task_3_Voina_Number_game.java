import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Task_3_Voina_Number_game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Integer> firstPlayer = returnSet(reader.readLine());
        LinkedHashSet<Integer> secondPlayer = returnSet(reader.readLine());

        for (int i = 0; i < 50; i++) {
            int firstNum = firstPlayer.iterator().next();
            firstPlayer.remove(firstNum);

            int secondNum = secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);

            if (firstNum > secondNum) {
                firstPlayer.add(firstNum);
                firstPlayer.add(secondNum);
            } else if (secondNum > firstNum) {
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            } else {
                firstPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
    private static LinkedHashSet<Integer> returnSet (String input) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        int[] add = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int j : add) {
            result.add(j);
        }
        return result;
    }
}