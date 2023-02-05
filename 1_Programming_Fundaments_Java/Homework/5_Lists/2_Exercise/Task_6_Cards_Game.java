import java.util.*;
import java.util.stream.Collectors;

public class Task_6_Cards_Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> playerOne = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> playerTwo = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        determineTheWinner(playerOne, playerTwo);
    }
    private static void determineTheWinner (List<Integer> playerOne, List<Integer> playerTwo) {
        List<Integer> result = new ArrayList<>();
        String name = "";
        for (int i = 0; i < Math.min(playerOne.size(), playerTwo.size()); i++) {
            if (playerOne.get(i) > playerTwo.get(i)) {
                playerOne.add(playerOne.get(i));
                playerOne.add(playerTwo.get(i));
                playerOne.remove(i);
                playerTwo.remove(i);
                --i;
            } else if (playerOne.get(i) < playerTwo.get(i)) {
                playerTwo.add(playerTwo.get(i));
                playerTwo.add(playerOne.get(i));
                playerOne.remove(i);
                playerTwo.remove(i);
                --i;
            } else if (Objects.equals(playerOne.get(i), playerTwo.get(i))) {
                playerOne.remove(i);
                playerTwo.remove(i);
                --i;
            }
        }
        if (playerOne.size() < playerTwo.size()) {
            result = playerTwo;
            name = "Second";
        } else if (playerOne.size() > playerTwo.size()) {
            result = playerOne;
            name = "First";
        }
        int sum = 0;
        for (Integer integer : result) {
            sum += integer;
        }
        System.out.printf("%s player wins! Sum: %d", name, sum);
    }
}